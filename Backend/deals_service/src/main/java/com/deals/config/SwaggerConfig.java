package com.deals.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
    	return new Docket(DocumentationType.SWAGGER_2).groupName("Coupons and Deals").apiInfo(metaData()).select()
				.paths(regex("/deals.*")).build();
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Deals API")
                .description("\"Deals configuration for application \"")
                .version("1.1.0")
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
//                .contact(new Contact("Tech Interface", "https://www.youtube.com/channel/UCMpJ8m1w9t7EFcF9x8rs02A", "info@techinterface.com"))
                .build();
    }
    
    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }
    //for Swagger api doc generation
    //http://localhost:8091/v2/api-docs
}