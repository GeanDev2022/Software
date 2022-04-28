package com.proyecto.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "tipoServicio")
	private int tipoServicio;

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

	public int getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(int tipoServicio) {
		this.tipoServicio = tipoServicio;
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
