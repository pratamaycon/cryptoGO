package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.core.springfox;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiDoc() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metaData()).select()
				.apis(RequestHandlerSelectors.basePackage("com.desenvolvimento.aplicacoes.corp20212.CryptoGO"))
				.paths(PathSelectors.any()).paths(Predicates.not(PathSelectors.regex("/v1.*"))).build()
				.globalOperationParameters(Collections
						.singletonList(new ParameterBuilder().name("Authorization").description("Bearer token")
								.modelRef(new ModelRef("string")).parameterType("header").required(true).build()));
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Api Rest by Desenvolvimento de Aplicações Corporativas").description(
				"Api Rest desenvolvida como avalicação da disciplina Desenvolvimento de Aplicações Corporativas")
				.version("1.0").contact(new Contact("Maycon Prata", "", "mayconprata@id.uff.br"))
				.license("Apache License VERSION 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
}
