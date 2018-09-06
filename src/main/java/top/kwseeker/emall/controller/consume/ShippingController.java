package top.kwseeker.emall.controller.consume;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.pojo.Shipping;

import javax.servlet.http.HttpSession;

/**
 * 收货信息
 */
@RestController
@RequestMapping("/shipping/")
@Api(description = "收货信息")
public class ShippingController {

    /**
     * @param shipping 收货信息对象
     */
    @PostMapping("add")
    @ApiOperation("添加收货信息")
    public ServerResponse add(HttpSession session, Shipping shipping){
        return null;
    }


    @DeleteMapping("del")
    @ApiOperation("删除收货信息")
    public ServerResponse del(HttpSession session,Integer shippingId){
        return null;
    }

    @PostMapping("update")
    @ApiOperation("更新收货信息")
    public ServerResponse update(HttpSession session,Shipping shipping){
        return null;
    }


    @GetMapping("select")
    @ApiOperation("参看某条收货信息")
    public ServerResponse<Shipping> select(HttpSession session,Integer shippingId){
        return null;
    }


    @GetMapping("list.do")
    @ApiOperation("分页查看所有收货信息列表")
    public ServerResponse<PageInfo> list(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10")int pageSize,
                                         HttpSession session){
        return null;
    }
}
