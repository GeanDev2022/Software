package com.proyecto.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = -1141225884903430612L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personaId;

	@Column(unique = true, nullable = false)
	private int cedulaPersona;

	@Column(name = "nombrePersona", length = 300, nullable = false)
	private String nombrePersona;

	// ****mirar si se deja como edad o como fecha de nacimiento****
	@Column(name = "edadPersona", nullable = false)
	private int edadPersona;

	@Column(name = "direccionPersona", length = 300, nullable = false)
	private String direccionPersona;

	@Column(name = "celularPersona", nullable = false)
	private int celularPersona;

	public int getPersonaId() {
		return personaId;
	}

	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	public int getCedulaPersona() {
		return cedulaPersona;
	}

	public void setCedulaPersona(int cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public int getEdadPersona() {
		return edadPersona;
	}

	public void setEdadPersona(int edadPersona) {
		this.edadPersona = edadPersona;
	}

	public String getDireccionPersona() {
		return direccionPersona;
	}

	public void setDireccionPersona(String direccionPersona) {
		this.direccionPersona = direccionPersona;
	}

	public int getCelularPersona() {
		return celularPersona;
	}

	public void setCelularPersona(int celularPersona) {
		this.celularPersona = celularPersona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(personaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return personaId == other.personaId;
	}

	@Override
	public String toString() {
		return "Persona [personaId=" + personaId + ", cedulaPersona=" + cedulaPersona + ", nombrePersona="
				+ nombrePersona + ", edadPersona=" + edadPersona + ", direccionPersona=" + direccionPersona
				+ ", celularPersona=" + celularPersona + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	

}
