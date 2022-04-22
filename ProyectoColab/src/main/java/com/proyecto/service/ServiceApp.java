package com.proyecto.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.entity.Cita;
import com.proyecto.entity.Comentario;
import com.proyecto.entity.Servicio;
import com.proyecto.entity.TipoServicio;
import com.proyecto.entity.TipoUsuario;
import com.proyecto.entity.Usuario;

public interface ServiceApp {
	

	// Usuario
	public String saveUsuario(Usuario usuario);
	public Iterable<Usuario> findAllUsuario();
	public Page<Usuario> findAllUsuario(Pageable pageable);
	public Optional<Usuario> findByIdUsuario(int id);
	public String buscarUsuario(int id);
	public void deleteByIdUsuario(int id);
	public String Autenticarusuario(String email, String contrasena);
	public String actualizarUsuario(Usuario usuario);
	
	// TipoUsuario
	public String saveTipoUsuario(TipoUsuario tipoUsuario);
	public Iterable<TipoUsuario> findAllTipoUsuario();
	public Page<TipoUsuario> findAllTipoUsuario(Pageable pageable);
	public Optional<TipoUsuario> findByIdTipoUsuario(int id);
	public void deleteByIdTipoUsuario(int id);
	public String actualizarTipoUsuario(TipoUsuario tipoUsuario);
	
	// TipoServicio
	public String saveTipoServicio(TipoServicio tipoServicio);
	public Iterable<TipoServicio> findAllTipoServicio();
	public Page<TipoServicio> findAllTipoServicio(Pageable pageable);
	public Optional<TipoServicio> findByIdTipoServicio(int id);
	public void deleteByIdTipoServicio(int id);
	public String actualizarTipoServicio(TipoServicio tipoServicio);
	
	// Servicio
	public String saveServicio(Servicio servicio);
	public Iterable<Servicio> findAllServicio();
	public Page<Servicio> findAllServicio(Pageable pageable);
	public Optional<Servicio> findByIdServicio(int id);
	public void deleteByIdServicio(int id);
	public String buscarServicio(int id);
	public String actualizarServicio (Servicio servicio);

	// Comentario
	public String saveComentario(Comentario comentario);
	public Iterable<Comentario> findAllComentario();
	public Page<Comentario> findAllComentario(Pageable pageable);
	public Optional<Comentario> findByIdComentario(int id);
	public void deleteByIdComentario(int id);
	public String actualizarComentario(Comentario comentario);
	
	// Cita
	public String saveCita(Cita cita);
	public Iterable<Cita> findAllCita();
	public Page<Cita> findAllCita(Pageable pageable);
	public Optional<Cita> findByIdCita(int id);
	public void deleteByIdCita(int id);
	public String actualizarFechaCita(Cita cita);
	public String updateCita(Cita cita);
	

}
