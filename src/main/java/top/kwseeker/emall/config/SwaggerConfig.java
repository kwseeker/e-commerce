package top.kwseeker.emall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc   //?
public class SwaggerConfig implements WebMvcConfigurer {

    /**
     * 修复 访问 swagger-ui.html 404 问题
     *  具体参考： 深入 Spring 系列之静态资源处理 https://blog.coding.net/blog/spring-static-resource-process
     *             Serving of Resources https://docs.spring.io/spring/docs/4.3.x/spring-framework-reference/htmlsingle/#mvc-config-static-resources
     *  原因是SpringMVC本身不会自动把/swagger-ui.html这个路径映射到对应的目录META-INF/resources/下面。
     * 或者 xml中配置
     * <mvc:resources location="classpath:/META-INF/resources/" mapping="swagger-ui.html"/>
     * <mvc:resources location="classpath:/META-INF/resources/webjars/" mapping="/webjars/**"/>
     * 或者将请求交给默认的Servlet
     *  <mvc:default-servlet-handler/>
     * TODO： SpringMVC 和 SpringBoot 静态资源路径配置过程, webjar形式的 Swagger-ui的静态文件默认被映射到哪里去了？
     *  SpringBoot默认静态资源路径
     *      classpath:/META-INF/resources/
     *      classpath:/resources/
     *      classpath:/static/
     *      classpath:/public/
     *  TODO: default-servlet 工作原理 与 DispatcherServlet 有何不同？
     */
    //方法一
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    //方法二
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(setApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.kwseeker.emall.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo setApiInfo() {
        return new ApiInfoBuilder()
                .title("电子商城 API")
                .description("包括")
                .version("1.0")
                .build();
    }
}
