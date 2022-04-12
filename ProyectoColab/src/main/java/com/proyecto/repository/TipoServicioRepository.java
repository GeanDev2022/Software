package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.proyecto.entity.TipoServicio;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, Integer> {
	
	@Procedure(procedureName = "creartiposervicio")
	String ProcedureinsertarTipoServicio(String nombreTipoServicio);
	
	@Procedure(procedureName = "modificartiposervicio")
	String ProceduremodificarTipoServicio(int tipoServicioid, String nombreTipoServicio);
	
	@Procedure(procedureName = "eliminartiposervicio")
	String ProcedureeliminarTipoServicio(int tipoServicioid);

}
