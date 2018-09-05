package top.kwseeker.emall.controller.manage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.kwseeker.emall.common.ServerResponse;

import javax.servlet.http.HttpSession;

/**
 * 分类管理
 */
@RestController
@RequestMapping("/manage/category")
@Api(description = "分类管理")
public class CategoryManageController {

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
        return null;
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
        return null;
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
        return null;
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
        return null;
    }
}
