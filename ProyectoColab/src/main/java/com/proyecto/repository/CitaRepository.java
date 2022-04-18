package com.proyecto.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.proyecto.entity.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
	
	@Procedure(procedureName = "crearcita")
	String ProcedureinsertarCita(String direccionCita, int servicioservicioId, int personaId);
	
	@Procedure(procedureName = "modificarcita")
	String ProceduremodificarCita(int citaId,String direccionCita, Date fechaCita, int servicioservicioId, int personaId);
	
	@Procedure(procedureName = "eliminarcita")
	String ProcedureeliminarCita(int citaId);

}
