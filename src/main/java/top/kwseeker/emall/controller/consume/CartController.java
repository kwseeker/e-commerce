package top.kwseeker.emall.controller.consume;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.kwseeker.emall.common.Const;
import top.kwseeker.emall.common.ResponseCode;
import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.pojo.User;
import top.kwseeker.emall.service.ICartService;
import top.kwseeker.emall.vo.CartVo;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/cart/")
@Api(description = "购物车信息")
public class CartController {

    @Autowired
    private ICartService iCartService;

    @GetMapping("list")
    @ApiOperation(value = "获取当前用户购物车")
    public ServerResponse<CartVo> list(HttpSession session) {
        //验证是否登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        //获取购物车商品列表
        return iCartService.list(user.getId());
    }

    @PostMapping("add")
    @ApiOperation(value = "添加商品到购物车")
    public ServerResponse<CartVo> add(HttpSession session, Integer count, Integer productId) {
        //验证是否登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iCartService.add(user.getId(), productId, count);
    }

    @PostMapping("update")
    @ApiOperation(value = "修改商品购买数量")
    public ServerResponse<CartVo> update(HttpSession session, Integer count, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iCartService.update(user.getId(), productId, count);
    }

    //TODO: Delete请求有没有不能被Get/Post替代的场景？
//    @DeleteMapping("delete_product")  //Spring对Get/Post外其他请求没有解析处理，无法获取参数，需要自己添加过滤器获取参数
    @PostMapping("delete_product")
    @ApiOperation("删除购物车商品")    //删除多项商品产品商品号以逗号分隔
    public ServerResponse<CartVo> deleteProduct(HttpSession session, String productIds) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.deleteProduct(user.getId(), productIds);
    }

    @GetMapping("select_all")
    @ApiOperation("全选中购物车商品")
    public ServerResponse<CartVo> selectAll(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(), null, Const.Cart.CHECKED);
    }

    @GetMapping("un_select_all")
    @ApiOperation("取消全选购物车商品")
    public ServerResponse<CartVo> unSelectAll(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(), null, Const.Cart.UN_CHECKED);
    }

    @GetMapping("select")
    @ApiOperation("选中购物车中某商品")
    public ServerResponse<CartVo> select(HttpSession session, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(), productId, Const.Cart.CHECKED);
    }

    @GetMapping("un_select")
    @ApiOperation("取消选中购物车中某商品")
    public ServerResponse<CartVo> unSelect(HttpSession session, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(), productId, Const.Cart.UN_CHECKED);
    }

    @GetMapping("get_cart_product_count")
    @ApiOperation("获取购物车商品的数量")
    public ServerResponse<Integer> getCartProductCount(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createBySuccess(0);
        }
        return iCartService.getCartProductCount(user.getId());
    }
}
