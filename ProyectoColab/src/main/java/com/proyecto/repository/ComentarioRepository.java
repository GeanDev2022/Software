package com.proyecto.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.proyecto.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	@Procedure(procedureName = "crearcomentario")
	String ProcedureinsertarComentario(int calificacion, String resenaComentario, int usuario, int cita);

	@Procedure(procedureName = "modificarcomentario")
	String ProceduremodificarComentario(int comentarioid, int calificacion, String resenaComentario, int usuario);

	@Procedure(procedureName = "eliminarcomentario")
	String ProcedureeliminarComentario(int comentarioId);
	
	@Procedure(name = "em.ProcedureListarComentariosPersona") 
	Map<String, ?> ProcedureListarComentariosPersona(int person_id);

}
