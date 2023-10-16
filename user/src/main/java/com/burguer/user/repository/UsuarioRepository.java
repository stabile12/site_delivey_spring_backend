package com.burguer.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.burguer.user.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
  
  public UserDetails findByEmail(String email);

}
