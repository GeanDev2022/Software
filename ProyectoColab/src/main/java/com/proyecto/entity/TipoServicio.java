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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TipoServicio")
public class TipoServicio implements Serializable {

	private static final long serialVersionUID = -8109810167141483451L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tipoServicioId;

	@Column(name = "nombreTipoServicio", length = 300, nullable = false)
	private String nombreTipoServicio;

	public int getTipoServicioId() {
		return tipoServicioId;
	}

	public void setTipoServicioId(int tipoServicioId) {
		this.tipoServicioId = tipoServicioId;
	}

	public String getNombreTipoServicio() {
		return nombreTipoServicio;
	}

	public void setNombreTipoServicio(String nombreTipoServicio) {
		this.nombreTipoServicio = nombreTipoServicio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoServicioId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoServicio other = (TipoServicio) obj;
		return tipoServicioId == other.tipoServicioId;
	}

}
