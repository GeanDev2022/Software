package com.proyecto.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JoinColumn(name = "personaId")
	private Usuario usuario;

	@OneToOne(mappedBy = "cita")
	@JsonIgnore
	private Servicio servicio;

	public int getCitaId() {
		return citaId;
	}

	public void setCitaId(int citaId) {
		this.citaId = citaId;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getDireccionCita() {
		return direccionCita;
	}

	public void setDireccionCita(String direccionCita) {
		this.direccionCita = direccionCita;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(citaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cita other = (Cita) obj;
		return citaId == other.citaId;
	}

	

}
