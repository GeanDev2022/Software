package com.proyecto.entity;

import java.io.Serializable;
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
@Table(name = "Servicio")
public class Servicio implements Serializable {

	private static final long serialVersionUID = 5927303700338490082L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ServicioId;

	@Column(name = "nombreServicio", length = 300, nullable = false)
	private String nombreServicio;

	@Column(name = "precio", nullable = false)
	private int precio;

	@ManyToOne
	@JoinColumn(name = "usuarioId")
	private TipoServicio tipoServicio;

	@OneToOne(mappedBy = "servicio")
	@JsonIgnore
	private Cita cita;

	public int getServicioId() {
		return ServicioId;
	}

	public void setServicioId(int servicioId) {
		ServicioId = servicioId;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ServicioId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		return ServicioId == other.ServicioId;
	}

}
