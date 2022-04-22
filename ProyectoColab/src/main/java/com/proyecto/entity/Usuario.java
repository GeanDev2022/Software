package com.proyecto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Usuario")
public class Usuario extends Persona implements Serializable {

	private static final long serialVersionUID = 4238483133610393837L;

	@Column(name = "emailUsuario", length = 300, nullable = false, unique = true)
	private String emailUsuario;

	@Column(name = "contrasenaUsuario", length = 300, nullable = false)
	private String contrasenaUsuario;
	
	@Column(name = "tipoUsuario")
	private int tipoUsuario;

	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	private List<Comentario> comentario;

	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	private List<Cita> cita;

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getContrasenaUsuario() {
		return contrasenaUsuario;
	}

	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public List<Cita> getCita() {
		return cita;
	}

	public void setCita(List<Cita> cita) {
		this.cita = cita;
	}

}
