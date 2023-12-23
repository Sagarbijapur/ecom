package com.ty.springboot_hospital_app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfi {

	
	public Docket getDocket() {
		Contact contact=new Contact("ty", "www.ty.com", "ty@gmail.com");
		
		List<VendorExtension> extensions=new ArrayList<>();
		
		ApiInfo apiInfo=new ApiInfo("hospital app", "hospital", "v 1", "www.ty@gmail.com", contact,"dfgh567", "www.ty@gmail.com", extensions);
		 return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.ty.springboot_hospital_app")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
}
