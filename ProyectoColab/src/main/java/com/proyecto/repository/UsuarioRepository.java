package com.proyecto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.proyecto.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

/**
	@Query(value = "select Autenticarusuario", nativeQuery = true)
	String Sautenticarusuario(String email, String contrasena);
**/
	@Procedure(procedureName = "Autenticarusuario")
	String Procedureautenticarusuario(String email, String contrasena);
	
	
}
