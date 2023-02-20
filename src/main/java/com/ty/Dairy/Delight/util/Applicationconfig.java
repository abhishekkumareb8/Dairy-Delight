package com.ty.Dairy.Delight.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Applicationconfig {

	@Bean
	public Docket getDocket() {

		Contact contact = new Contact("ty", "testYentra.com", "testyentra@mail.com");
		List<VendorExtension> extensions = new ArrayList<VendorExtension>();

		ApiInfo apiInfo = new ApiInfo("Dairy Delight App", "Boot app for Dairy Delight app", "1.0", "testyentra.com", contact,
				"apache tomecate", "www.apache.cpom", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.Dairy.Delight"))
				.build().apiInfo(apiInfo);

	}
}
