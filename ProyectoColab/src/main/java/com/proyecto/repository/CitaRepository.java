package com.proyecto.repository;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.proyecto.entity.Cita;
import com.proyecto.entity.Servicio;
import com.proyecto.entity.Usuario;

public interface CitaRepository extends JpaRepository<Cita, Integer> {

	@Procedure(procedureName = "crearcita")
	String ProcedureinsertarCita(String direccionCita, Date fechaCita, Serializable servicioservicioId, Usuario personaId);
	
	@Procedure(procedureName = "modificarcita")
	String ProceduremodificarCita(int citaId,String direccionCita, Date fechaCita, int servicioservicioId, int personaId);
	
	@Procedure(procedureName = "eliminarcita")
	String ProcedureeliminarCita(int citaId);

}
