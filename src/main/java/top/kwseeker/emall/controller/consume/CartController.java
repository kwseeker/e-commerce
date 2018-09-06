package top.kwseeker.emall.controller.consume;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.vo.CartVo;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/cart/")
@Api(description = "购物车信息")
public class CartController {

    @GetMapping("list")
    @ApiOperation(value = "获取当前用户购物车")
    public ServerResponse<CartVo> list(HttpSession session) {
        return null;
    }

    @PostMapping("add")
    @ApiOperation(value = "添加商品到购物车")
    public ServerResponse<CartVo> add(HttpSession session, Integer count, Integer productId) {
        return null;
    }

    @PostMapping("update")
    @ApiOperation(value = "修改商品购买数量")
    public ServerResponse<CartVo> update(HttpSession session, Integer count, Integer productId) {
        return null;
    }

    @DeleteMapping("delete_product")
    @ApiOperation("删除购物车某项商品")
    public ServerResponse<CartVo> deleteProduct(HttpSession session, String productIds) {
        return null;
    }

    @GetMapping("select_all")
    @ApiOperation("全选中购物车商品")
    public ServerResponse<CartVo> selectAll(HttpSession session) {
        return null;
    }

    @GetMapping("un_select_all")
    @ApiOperation("取消全选购物车商品")
    public ServerResponse<CartVo> unSelectAll(HttpSession session) {
        return null;
    }

    @GetMapping("select")
    @ApiOperation("选中购物车中某商品")
    public ServerResponse<CartVo> select(HttpSession session, Integer productId) {
        return null;
    }

    @GetMapping("un_select")
    @ApiOperation("取消选中购物车中某商品")
    public ServerResponse<CartVo> unSelect(HttpSession session, Integer productId) {
        return null;
    }

    @GetMapping("get_cart_product_count")
    @ApiOperation("获取购物车商品的数量")
    public ServerResponse<Integer> getCartProductCount(HttpSession session) {
        return null;
    }
}
