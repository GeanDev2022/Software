package com.proyecto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import com.proyecto.entity.Comentario;
import com.proyecto.entity.Usuario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	@Procedure(procedureName = "crearcomentario")
	String ProcedureinsertarComentario(int calificacion, String resenaComentario, Usuario personaId);
	
	@Procedure(procedureName = "modificarcomentario")
	String ProceduremodificarComentario(int comentarioId, int calificacion, String resenaComentario, Usuario usuario);
	
	@Procedure(procedureName = "eliminarcomentario")
	String ProcedureeliminarComentario(int comentarioId);

}
