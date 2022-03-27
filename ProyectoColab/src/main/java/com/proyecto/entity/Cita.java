package com.proyecto.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cita")
public class Cita implements Serializable {

	private static final long serialVersionUID = 4674387131820229120L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int citaId;

	// mirar si es java.sql o java.util
	@Column(unique = true, nullable = false)
	private Date fechaCita;

	@Column(name = "direccionCita", length = 300, nullable = false)
	private String direccionCita;

	@ManyToOne
	@JoinColumn(name = "usuarioId")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "servicioId")
	private Servicio servicio;

}
