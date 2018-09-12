package top.kwseeker.emall.controller.manage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.kwseeker.emall.common.Const;
import top.kwseeker.emall.common.ResponseCode;
import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.pojo.User;
import top.kwseeker.emall.service.ICategoryService;
import top.kwseeker.emall.service.IUserService;

import javax.servlet.http.HttpSession;

/**
 * 分类管理
 * 接口：
 *  添加分类
 *  修改分类
 *  查询分类
 *
 * 数据表：
 * id parent_id name status sort_order create_time update_time
 */
@RestController
@RequestMapping("/manage/category")
@Api(description = "分类管理")
public class CategoryManageController {

    @Autowired
    IUserService iUserService;

    @Autowired
    ICategoryService iCategoryService;

    /**
     * 添加分类
     * @param session 用于身份验证，必须是管理员才可操作
     * @param categoryName 新增分类名称
     * @param parentId 父分类ID
     * @return 状态码（0：成功， 1：失败）和消息
     */
    @ApiOperation(value = "添加分类")
    @PostMapping("add_category")
    public ServerResponse addCategory(HttpSession session, String categoryName, @RequestParam(value = "parentId", defaultValue = "0") int parentId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        //校验一下是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //是管理员
            //增加我们处理分类的逻辑
            return iCategoryService.addCategory(categoryName, parentId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }

    /**
     * 设置分类名称
     * @param session 用于身份验证，必须是管理员才可操作
     * @param categoryId 分类id
     * @param categoryName 分类的名字
     * @return 状态码（0：成功， 1：失败）和消息
     */
    @ApiOperation(value = "修改分类名")
    @PostMapping("set_category_name")
    public ServerResponse setCategoryName(HttpSession session, Integer categoryId, String categoryName) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //更新categoryName
            return iCategoryService.updateCategoryName(categoryId, categoryName);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }

    /**
     * 查询某父分类所有一级子分类
     * @param session 用于身份验证，必须是管理员才可操作
     * @param categoryId 父分类id
     * @return 状态码（0：成功， 1：失败）和消息，以及子分类信息链表
     */
    @ApiOperation(value = "获取一级子分类")
    @GetMapping("get_category")
    public ServerResponse getChildrenParallelCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //查询子节点的category信息,并且不递归,保持平级
            return iCategoryService.getChildrenParallelCategory(categoryId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }

    /**
     * 查询父分类所有子分类
     * @param session 用于身份验证，必须是管理员才可操作
     * @param categoryId 父分类id
     * @return 状态码（0：成功， 1：失败）和消息，以及子分类信息链表
     */
    @ApiOperation(value = "递归获取子分类")
    @GetMapping("get_deep_category")
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //查询当前节点的id和递归子节点的id
//            0->10000->100000
            return iCategoryService.selectCategoryAndChildrenById(categoryId);

        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }
}
