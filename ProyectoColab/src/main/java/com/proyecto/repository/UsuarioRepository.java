package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
