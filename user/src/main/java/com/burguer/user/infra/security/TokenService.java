package com.burguer.user.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.burguer.user.models.Usuario;

@Service
public class TokenService {
  
  public String generateToken(Usuario usuario) {
    try {
      Algorithm algorithm = Algorithm.HMAC256("my-secret");
      String token = JWT.create()
          .withIssuer("auth-ms")
          .withSubject(usuario.getEmail())
          .withExpiresAt(generateExpirationDate())
          .sign(algorithm);

      return token;
    } catch (JWTCreationException e) {
      throw new RuntimeException("Erro ao criar o token");
    }
  }

  private Instant generateExpirationDate() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256("my-secret");
      return JWT.require(algorithm)
        .withIssuer("auth-ms")
        .build()
        .verify(token)
        .getSubject();
        

    } catch (JWTVerificationException e) {
      return "";
    }
  }
}
