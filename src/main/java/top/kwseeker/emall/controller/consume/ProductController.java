package top.kwseeker.emall.controller.consume;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.service.IProductService;
import top.kwseeker.emall.vo.ProductDetailVo;

/**
 * 用户端商品查看
 *
 * 获取某项商品详情
 * 获取商品列表（分页方式）
 */
@RestController
@RequestMapping("/product/")
@Api(description = "商品信息")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("detail")
    @ApiOperation("获取商品详情")
    public ServerResponse<ProductDetailVo> detail(Integer productId){
        return iProductService.getProductDetail(productId);
    }

    @GetMapping("list")
    @ApiOperation("分页获取商品列表")
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword",required = false)String keyword,
                                         @RequestParam(value = "categoryId",required = false)Integer categoryId,
                                         @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                         @RequestParam(value = "orderBy",defaultValue = "") String orderBy){
        return iProductService.getProductByKeywordCategory(keyword,categoryId,pageNum,pageSize,orderBy);
    }
}