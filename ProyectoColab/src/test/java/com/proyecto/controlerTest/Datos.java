package com.proyecto.controlerTest;
import java.util.Optional;
import com.proyecto.entity.*;

public class Datos {

	public static Usuario crearUsuario1(){
		Usuario usuario = new Usuario();
		usuario.setPersonaId(1);
		usuario.setCedulaPersona(12345);
		usuario.setCelularPersona(31700);
		usuario.setContrasenaUsuario("1234");
		usuario.setNombrePersona("igor");
		usuario.setCita(null);
		usuario.setComentario(null);
		usuario.setDireccionPersona("calle1");
		usuario.setEmailUsuario("correo1@gmail.com");
		usuario.setTipoUsuario(1);
		 return usuario;
	}
	
	public static Optional<Cita>crearCita1(){
	
		Cita cita = new Cita();
		cita.setCitaId(1);
		cita.setComentario(null);
		cita.setDireccionCita("calleA");
		cita.setDoctor(1);
		cita.setFechaCita(null);
		cita.setServicio(null);
		cita.setUsuario(null);
		cita.setServicio(null);
		 return Optional.of(cita);
	}
	
	
} 
