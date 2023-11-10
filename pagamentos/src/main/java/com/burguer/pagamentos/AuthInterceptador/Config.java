package com.burguer.pagamentos.AuthInterceptador;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config extends WebMvcConfigurationSupport {

  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new Interceptor())
      .addPathPatterns("/**");
  }
}
