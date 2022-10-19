package com.user.configuration;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.user.controller"))
//                .paths(PathSelectors.any())
//                .build().apiInfo(metaData());
//    }
//
//    private ApiInfo metaData() {
//        return new ApiInfoBuilder()
//                .title("Spring Boot Swagger Configuration")
//                .description("\"Swagger configuration for application \"")
//                .version("1.1.0")
//                .license("Apache 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
//                //.contact(new Contact("Sushmitha p", "https://www.google.com", "sushmitha112p@gmail.com"))
//                .build();
//    }
//    //for Swagger api doc generation
//    //http://localhost:8091/v2/api-docs
//}
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Coupons and Deals")
				.securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey()))
				.tags(new Tag("Users", "users related"), 
				          new Tag("Admin", "Authentication"),
				             new Tag("Roles","Role related"))
				.apiInfo(metaData()).select()
				//.paths(regex("/users.*"))
				.build();
	}

//	@Bean
//	public Docket adminApi() {
//		return new Docket(DocumentationType.SWAGGER_2).groupName("Coupons and Deals 2")
//				.securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey()))
//				.apiInfo(metaData()).select()
//				.paths(regex("/admin.*")).build();
//	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("User API").description("\"Users service for application \"")
				.version("1.1.0").license("Apache 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
//                .contact(new Contact("", "", ""))
				.build();
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	@Bean
	public InternalResourceViewResolver defaultViewResolver() {
		return new InternalResourceViewResolver();
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
	// for Swagger api doc generation
	// http://localhost:8091/v2/api-docs
}