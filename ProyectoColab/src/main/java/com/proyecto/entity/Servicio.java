package com.proyecto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Servicio")
public class Servicio implements Serializable {

	private static final long serialVersionUID = 5927303700338490082L;

	@Column(name = "ServicioId", nullable = false, unique = true)
	private int ServicioId;

	@Column(name = "nombre", length = 300, nullable = false)
	private String nombre;

	@Column(name = "precio", nullable = false)
	private int precio;

	@ManyToOne
	@JoinColumn(name = "usuarioId")
	private TipoServicio tipoServicio;
	
	@OneToOne(mappedBy = "servicio")
	@JsonIgnore
	private Cita cita;


}
