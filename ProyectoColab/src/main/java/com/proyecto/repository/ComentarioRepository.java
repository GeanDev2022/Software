package com.proyecto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import com.proyecto.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	@Procedure(procedureName = "crearcomentario")
	String ProcedureinsertarComentario(int calificacion, String resenaComentario, int personaId);
	
	@Procedure(procedureName = "modificarcomentario")
	String ProceduremodificarrComentario(int comentarioId, int calificacion, String resenaComentario, int personaId);
	
	@Procedure(procedureName = "eliminarcomentario")
	String ProcedureeliminarComentario(int comentarioId);

}
