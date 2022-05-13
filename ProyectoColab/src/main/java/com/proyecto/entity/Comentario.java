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
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "em.ProcedureListarComentariosPersona", procedureName = "listarcomentariospersona",
	parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name="personId", type = Integer.class)
	})	
})


@Table(name = "Comentario")
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1023358141631413409L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comentarioId;

	@Column(name = "resenaComentario", length = 300, nullable = false)
	private String resenaComentario;

	@Column(name = "calificacion", nullable = false)
	private int calificacion;

	@ManyToOne
	@JoinColumn(name = "personaId")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "citaId")
	private Cita cita;

	public int getComentarioId() {
		return comentarioId;
	}

	public void setComentarioId(int comentarioId) {
		this.comentarioId = comentarioId;
	}

	public String getResenaComentario() {
		return resenaComentario;
	}

	public void setResenaComentario(String resenaComentario) {
		this.resenaComentario = resenaComentario;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comentarioId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		return comentarioId == other.comentarioId;
	}

}
