package top.kwseeker.emall.service;

import com.github.pagehelper.PageInfo;
import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.pojo.Product;
import top.kwseeker.emall.vo.ProductDetailVo;

public interface IProductService {

    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId,Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName,Integer productId,int pageNum,int pageSize);

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);

}
