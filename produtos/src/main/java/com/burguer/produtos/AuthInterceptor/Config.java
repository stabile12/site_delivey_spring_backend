package com.burguer.produtos.AuthInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class Config extends WebMvcConfigurationSupport{
  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new Interceptor())
      .excludePathPatterns("/produtos/listar");
  }
}
