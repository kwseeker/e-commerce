package top.kwseeker.emall.service;

import com.github.pagehelper.PageInfo;
import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.pojo.Shipping;

public interface IShippingService {

    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse<String> del(Integer userId,Integer shippingId);

    ServerResponse update(Integer userId, Shipping shipping);

    ServerResponse<Shipping> select(Integer userId, Integer shippingId);

    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);

}
