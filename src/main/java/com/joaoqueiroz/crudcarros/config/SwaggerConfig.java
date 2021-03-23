package com.joaoqueiroz.crudcarros.config;

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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.joaoqueiroz.crudcarros.controllers.resources"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("API de CRUD de Veiculos")
                .description("API de crud de veiculo construida com Spring para o teste da Keyrus")
                .version("1.0")
                .contact(contact())
                .build();
    }

    private Contact contact(){
        return new Contact(
                "João Queiroz",
                "http://github.com/xxjoaoqueirozxx",
                "joaovic.pqueiroz@gmail.com");
    }

}
