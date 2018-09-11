package top.kwseeker.emall.controller.consume;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kwseeker.emall.common.Const;
import top.kwseeker.emall.common.ResponseCode;
import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.pojo.User;
import top.kwseeker.emall.service.IUserService;

import javax.servlet.http.HttpSession;

/**
 * 用户管理
 *
 * 用户登录及注销其实是Session记录及清除用户信息；
 *
 * 获取登录用户信息，先从Session中获取登录用户名然后通过用户名从数据库查用户信息；
 *
 * 用户忘记密码：发送问题，用户回答正确，创建一个Token(UUID库创建)，存储在缓存（暂时使用谷歌的
 * Guava作为缓存，后面可以换做Redis）中，并随着json
 * 返回给浏览器，前端页面负责读取此json中的token字段并作为重置密码的权限证明发送给后端。
 *
 * TODO: 使用Spring Security实现用户认证授权
 * TODO: Redis 替代 Guava 作为缓存
 * TODO: 添加MockMVC单元测试
 */
@RestController
@RequestMapping("/user/")
@Api(description = "用户操作")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     * @param session
     */
    @PostMapping(value = "login")
    @ApiOperation("用户登录")
    public ServerResponse<User> login(String username, String password, HttpSession session){
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @PostMapping(value = "logout")
    @ApiOperation("用户注销")
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @PostMapping(value = "register")
    @ApiOperation("用户注册")
    public ServerResponse<String> register(User user){
        return iUserService.register(user);
    }

    //检查用户名或email是否已经存在，已经存在的话则无效
    @PostMapping(value = "check_valid")
    @ApiOperation("新用户信息有效性检查")
    public ServerResponse<String> checkValid(String str, String type){
        return iUserService.checkValid(str, type);
    }

    @GetMapping(value = "get_user_info")
    @ApiOperation("获取登录用户信息")
    public ServerResponse<User> getUserInfo(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user != null){
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
    }

    @PostMapping(value = "forget_get_question")
    @ApiOperation("获取忘记密码问题")
    public ServerResponse<String> forgetGetQuestion(String username){
        return iUserService.selectQuestion(username);
    }

    @PostMapping(value = "forget_check_answer")
    @ApiOperation("校对忘记密码问题答案")
    public ServerResponse<String> forgetCheckAnswer(String username,String question,String answer){
        return iUserService.checkAnswer(username,question,answer);
    }


    @PostMapping(value = "forget_reset_password")
    @ApiOperation("忘记密码重置密码")
    public ServerResponse<String> forgetRestPassword(String username,String passwordNew,String forgetToken){
        return iUserService.forgetResetPassword(username,passwordNew,forgetToken);
    }

    //不管是否已经登录都检验一下旧密码
    @PostMapping(value = "reset_password")
    @ApiOperation("重置密码")
    public ServerResponse<String> resetPassword(HttpSession session,String passwordOld,String passwordNew){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return iUserService.resetPassword(passwordOld,passwordNew,user);
    }

    @PostMapping(value = "update_information")
    @ApiOperation("更新用户信息")
    public ServerResponse<User> update_information(HttpSession session,User user){
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response = iUserService.updateInformation(user);
        if(response.isSuccess()){
            response.getData().setUsername(currentUser.getUsername());
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @GetMapping(value = "get_information")
    @ApiOperation("获取用户信息")
    public ServerResponse<User> get_information(HttpSession session){
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iUserService.getInformation(currentUser.getId());
    }
}
