package top.kwseeker.emall.controller.manage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * 管理员登录
 */
@RestController
@RequestMapping("/manage/user")
@Api(description = "用户管理")
public class UserManageController {

    /**
     * 以管理员身份（管理员可能有多个）登录
     * @param username 管理员用户名
     * @param password 管理员密码
     * @param session
     * @return
     */
    @PostMapping(value="login")
    @ApiOperation("管理员登录")
    public ServerResponse<User> login(String username, String password, HttpSession session){
        return null;
    }

}