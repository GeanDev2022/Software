package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.proyecto.entity.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

	@Procedure(procedureName = "crearservicio")
	String ProcedureinsertarServicio(String nombreservicio, int precio, int tiposervicio);
	
	@Procedure(procedureName = "modificarservicio")
	String ProceduremodificarServicio(int servicioId, String nombreservicio, int precio, int tiposervicio);
	
	@Procedure(procedureName = "eliminarservicio")
	String ProcedureeliminarServicio(int servicioId);
}
