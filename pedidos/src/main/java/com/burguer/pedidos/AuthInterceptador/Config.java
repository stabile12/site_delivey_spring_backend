package com.burguer.pedidos.AuthInterceptador;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config extends WebMvcConfigurationSupport {

  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new Interceptor())
      .addPathPatterns("/pedidos/{id}","/pedidos/cliente/{id}");

    registry.addInterceptor(new AdminInterceptor())
      .addPathPatterns("/pedidos/{id}/enviado","/pedidos/{id}/entregue");
  }
}
