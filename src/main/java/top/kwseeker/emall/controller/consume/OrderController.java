package top.kwseeker.emall.controller.consume;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.kwseeker.emall.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 订单与支付
 */
@RestController
@RequestMapping("/order/")
@Api(description = "订单信息")
public class OrderController {

    /**
     * @param shippingId 用户的收货信息id（用户可能有多个收货地址选择一个）
     */
    @PostMapping("create")
    @ApiOperation("创建订单")
    public ServerResponse create(HttpSession session, Integer shippingId) {
        return null;
    }

    @DeleteMapping("cancel")
    @ApiOperation("取消订单")
    public ServerResponse cancel(HttpSession session, Long orderNo) {
        return null;
    }

    @GetMapping("get_order_cart_product")
    @ApiOperation("获取购物车中选中商品")
    public ServerResponse getOrderCartProduct(HttpSession session) {
        return null;
    }

    @GetMapping("detail")
    @ApiOperation("获取某订单详情信息")
    public ServerResponse detail(HttpSession session, Long orderNo) {
        return null;
    }

    @GetMapping("list")
    @ApiOperation("分页查看用户所有订单")
    public ServerResponse list(HttpSession session,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        return null;
    }

    @PostMapping("pay")
    @ApiOperation("支付")
    public ServerResponse pay(HttpSession session, Long orderNo, HttpServletRequest request) {
        return null;
    }

    @PostMapping("alipay_callback")
    @ApiOperation("支付完成")
    public Object alipayCallback(HttpServletRequest request) {
        return null;
    }

    @GetMapping("query_order_pay_status")
    @ApiOperation("查询订单支付状态")
    public ServerResponse<Boolean> queryOrderPayStatus(HttpSession session, Long orderNo) {
        return null;
    }
}
