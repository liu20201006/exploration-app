package com.aaa.liuhao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.aaa.liuhao.staticstatus.RequestURLProperties.PACKAGE_CONTROLLER_URL;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/18 13:04
 * @Version
 * @Description //TODO
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()// 选择swagger具体生效的接口是什么？(service, controller, mapper)
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_CONTROLLER_URL))
                .paths(PathSelectors.any())
                .build();

    }

    /**
     * @Description:
     * 构建了整个项目的一些描述信息
     * @author:Liu Hao
     * @param:[]
     * @return:springfox.documentation.service.ApiInfo
     * @exception:
     * @date:2020/5/18 13:05
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测绘管理系统")
                .description("某市的测绘管理系统")
                .contact(new Contact("Seven Lee", "http://www.seven.com", "sevenLee@Gmail.com"))
                .version("1.0")
                .build();
    }
}
