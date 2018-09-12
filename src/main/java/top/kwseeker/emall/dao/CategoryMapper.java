package top.kwseeker.emall.dao;

import top.kwseeker.emall.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    // TODO: 这个方法被MyBatis翻译成的JDBC代码是什么样的？
    // TODO: resultMap="BaseResultMap" 怎么和 List<Category> 对应起来的？ 接口中方法多个参数为什么对应 parameterType="map"?
    // 调试时发现它会先从MapperProxy中获取这个方法映射到的MapperMethod类，
    // 每个Mapper方法都对应一个这种类，用于解析参数最后通过SqlSessionTemplate查找对应的SqlSession代理类查询
    // 并按参数返回结果
    // 这只是怎么找到SqlSession代理类的，Mapper.xml中sql语句怎么解析成JDBC代码的还是看MyBatis初始化解析XML流程
    // https://blog.csdn.net/u010288264/article/details/72650208
    // 依据这个博客所说在XMLMapperBuilder configurationElement()中加断点，重启服务
    // XMLMapperBuilder类 parseStatementNode() 中 builderAssistant.addMappedStatement()
    List<Category> selectCategoryChildrenByParentId(Integer parentId);
}
