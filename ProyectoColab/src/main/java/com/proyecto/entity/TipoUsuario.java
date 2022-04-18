package com.proyecto.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TipoUsuario")
public class TipoUsuario implements Serializable {

	private static final long serialVersionUID = -493019322928630798L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tipoUsuarioId;

	@Column(name = "nombreTipoUsuario", length = 200, nullable = false)
	private String nombreTipoUsuario;

	

	public int getTipoUsuarioId() {
		return tipoUsuarioId;
	}

	public void setTipoUsuarioId(int tipoUsuarioId) {
		this.tipoUsuarioId = tipoUsuarioId;
	}

	public String getNombreTipoUsuario() {
		return nombreTipoUsuario;
	}

	public void setNombreTipoUsuario(String nombreTipoUsuario) {
		this.nombreTipoUsuario = nombreTipoUsuario;
	}


	@Override
	public int hashCode() {
		return Objects.hash(tipoUsuarioId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoUsuario other = (TipoUsuario) obj;
		return tipoUsuarioId == other.tipoUsuarioId;
	}

}
