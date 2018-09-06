package top.kwseeker.emall.controller.manage;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.vo.OrderVo;

import javax.servlet.http.HttpSession;

/**
 * 订单管理
 */
@RestController
@RequestMapping("/manage/order")
@Api(description = "订单管理")
public class OrderManageController {


    @GetMapping("list")
    @ResponseBody
    @ApiOperation(value = "分页获取订单列表")
    public ServerResponse<PageInfo> orderList(HttpSession session,
                                              @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){

        return null;
    }

    @GetMapping("detail")
    @ResponseBody
    @ApiOperation(value = "获取订单详情")
    public ServerResponse<OrderVo> orderDetail(HttpSession session, Long orderNo){

        return null;
    }

    @GetMapping("search")
    @ResponseBody
    @ApiOperation(value = "搜索订单")
    public ServerResponse<PageInfo> orderSearch(HttpSession session, Long orderNo,
                                                @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        return null;
    }

    @GetMapping("send_goods")
    @ResponseBody
    @ApiOperation(value = "邮递商品")
    public ServerResponse<String> orderSendGoods(HttpSession session, Long orderNo){

        return null;
    }
}
