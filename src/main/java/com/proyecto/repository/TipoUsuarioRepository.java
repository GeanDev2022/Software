package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.proyecto.entity.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
	
	@Procedure(procedureName = "creartipousuario")
	String ProcedureinsertarTipoUsuario(String nombreTipoUsuario);
	
	@Procedure(procedureName = "modificartipousuario")
	String ProceduremodificarTipoUsuario(int tipoUsuarioId, String nombreTipoUsuario);
	
	@Procedure(procedureName = "eliminartipousuario")
	String ProcedureeliminarTipoUsuario(int tipoUsuarioId);
}
