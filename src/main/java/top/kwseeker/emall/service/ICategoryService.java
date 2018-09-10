package top.kwseeker.emall.service;

import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.pojo.Category;

import java.util.List;

public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId,String categoryName);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
