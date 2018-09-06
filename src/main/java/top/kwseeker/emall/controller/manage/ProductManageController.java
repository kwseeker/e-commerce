package top.kwseeker.emall.controller.manage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.kwseeker.emall.common.ServerResponse;
import top.kwseeker.emall.pojo.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 产品管理
 */
@RestController
@RequestMapping("/manage/product")
@Api(description = "商品管理")
public class ProductManageController {

    /**
     * 添加新商品
     * @param session 身份验证
     * @param product 产品对象
     */
    @PostMapping("save")
    @ApiOperation(value = "添加商品")
    public ServerResponse productSave(HttpSession session, Product product) {
        return null;
    }

    /**
     * 设置商品状态（在售、下架、或删除）
     * @param session 管理员身份认证
     * @param productId 产品ID
     * @param status 产品状态
     */
    @PostMapping("set_sale_status")
    @ApiOperation(value = "设置产品状态")
    public ServerResponse setSaleStatus(HttpSession session, Integer productId, Integer status) {
        return null;
    }

    /**
     * 获取产品详情
     */
    @GetMapping("detail")
    @ApiOperation(value = "获取产品详情")
    public ServerResponse getDetail(HttpSession session, Integer productId) {
        return null;
    }

    /**
     * 分页获取产品列表
     */
    @GetMapping("list")
    @ApiOperation(value = "分页获取产品列表")
    public ServerResponse getList(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return null;
    }

    /**
     * 分页搜索产品
     * @param session
     * @param productName
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("search")
    @ApiOperation(value = "分页搜索产品")
    public ServerResponse productSearch(HttpSession session, String productName, Integer productId,
                                        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return null;
    }

    /**
     * 文件上传
     */
    @PostMapping("upload")
    @ApiOperation(value = "文件上传")
    public ServerResponse upload(HttpSession session,
                                 @RequestParam(value = "upload_file", required = false) MultipartFile file,
                                 HttpServletRequest request) {
        return null;
    }

    /**
     * 富文本图片上传
     */
    @PostMapping("richtext_img_upload")
    @ApiOperation(value = "富文本图片上传")
    public Map richtextImgUpload(HttpSession session,
                                 @RequestParam(value = "upload_file", required = false) MultipartFile file,
                                 HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
