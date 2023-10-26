package com.burguer.produtos.AuthInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.burguer.produtos.http.AuthRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor{
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    AuthRequest authRequest = new AuthRequest();
    String token = request.getHeader("Authorization").replace("Bearer ", "");
    System.out.println(token);

    var result = authRequest.request(token, "http://localhost:8082/usuarios-ms/auth/checar-role");
    if (result.equals("true")) {
      return true;
    }else {
      response.setStatus(401);
      return false;
    }

  }
}
