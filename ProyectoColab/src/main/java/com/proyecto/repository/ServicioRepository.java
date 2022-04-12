package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.proyecto.entity.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer>{

	
	
	@Procedure(procedureName = "serviceinproc")
	String ProcedureinsertarServicio(String nombreservicio, int precio, int tiposervicio);
}
