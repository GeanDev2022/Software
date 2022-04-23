package com.proyecto.repository;



import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.proyecto.entity.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
	
	@Procedure(procedureName = "crearcita")
	String ProcedureinsertarCita(String direccionCita, Date fechaCita,int servicioservicioId, int personaId, int doctor);
	
	@Procedure(procedureName = "modificarcita")
	String ProceduremodificarCita(int citaId,String direccionCita,Date fechaCita , int servicioservicioId, int personaId, int dock);
	
	@Procedure(procedureName = "modificarfechacita")
	String ProceduremodificarFechaCita(int citaId, Date fechaCita);
	
	@Procedure(procedureName = "eliminarcita")
	String ProcedureeliminarCita(int citaId);

}
