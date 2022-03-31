package com.shenblog.core.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ShenChuanBiao
 * @title: SwaggerConfig
 * @projectName system
 * @description: TODO
 * @date 2022/3/25 15:09
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

  @Bean
  public Docket systemDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfoSystem())
        .groupName("后台管理接口")
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.shenblog"))
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .paths(PathSelectors.ant("/sys/**"))
        .build();
  }

  public ApiInfo apiInfoSystem() {
    return new ApiInfoBuilder()
        .version("0.0.1")
        .description("用户管理、角色管理、文章管理")
        .title("后台管理接口")
        .build();
  }

  @Bean
  public Docket webDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfoWeb())
        .groupName("前端显示接口")
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.shenblog"))
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .paths(PathSelectors.ant("/front/**"))
        .build();
  }

  private ApiInfo apiInfoWeb() {
    return new ApiInfoBuilder()
        .version("0.0.1")
        .description("前台显示的博客，博主信息，以及一些别的")
        .title("前端显示接口")
        .build();
  }

  /**
   * 解决Spring boot 2.6.*版本和Swagger3.0不兼容问题
   * @return
   */
  @Bean
  public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
    return new BeanPostProcessor() {

      @Override
      public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof WebMvcRequestHandlerProvider) {
          customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
        }
        return bean;
      }

      private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
        List<T> copy = mappings.stream()
                .filter(mapping -> mapping.getPatternParser() == null)
                .collect(Collectors.toList());
        mappings.clear();
        mappings.addAll(copy);
      }

      @SuppressWarnings("unchecked")
      private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
        try {
          Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
          field.setAccessible(true);
          return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
        } catch (IllegalArgumentException | IllegalAccessException e) {
          throw new IllegalStateException(e);
        }
      }
    };
  }
}
