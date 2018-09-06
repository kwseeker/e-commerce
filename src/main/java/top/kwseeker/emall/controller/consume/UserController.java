package top.kwseeker.emall.controller.consume;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/user/")
@Api(description = "用户操作")
public class UserController {

    /**
     * 用户登录
     * @param session
     */
    @PostMapping(value = "login")
    @ApiOperation("用户登录")
    public ServerResponse<User> login(String username, String password, HttpSession session){
        return null;
    }

    @PostMapping(value = "logout")
    @ApiOperation("用户注销")
    public ServerResponse<String> logout(HttpSession session){
        return null;
    }

    @PostMapping(value = "register")
    @ApiOperation("用户注册")
    public ServerResponse<String> register(User user){
        return null;
    }


    @PostMapping(value = "check_valid")
    @ApiOperation("用户有效性检查")
    public ServerResponse<String> checkValid(String str, String type){
        return null;
    }

    @GetMapping(value = "get_user_info")
    @ApiOperation("获取用户信息")
    public ServerResponse<User> getUserInfo(HttpSession session){
        return null;
    }


    @GetMapping(value = "forget_get_question")
    @ApiOperation("获取忘记密码问题")
    public ServerResponse<String> forgetGetQuestion(String username){
        return null;
    }

    @PostMapping(value = "forget_check_answer")
    @ApiOperation("校对忘记密码问题答案")
    public ServerResponse<String> forgetCheckAnswer(String username,String question,String answer){
        return null;
    }


    @PostMapping(value = "forget_reset_password")
    @ApiOperation("忘记密码重置密码")
    public ServerResponse<String> forgetRestPassword(String username,String passwordNew,String forgetToken){
        return null;
    }

    @PostMapping(value = "reset_password")
    @ApiOperation("重置密码")
    public ServerResponse<String> resetPassword(HttpSession session,String passwordOld,String passwordNew){
        return null;
    }

    @PostMapping(value = "update_information")
    @ApiOperation("更新用户信息")
    public ServerResponse<User> update_information(HttpSession session,User user){
        return null;
    }

    @GetMapping(value = "get_information")
    @ApiOperation("获取用户信息")
    public ServerResponse<User> get_information(HttpSession session){
        return null;
    }
}
