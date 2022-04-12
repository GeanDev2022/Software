package com.proyecto.service;

import java.util.List;
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
	public Usuario saveUsuario(Usuario usuario);
	public Iterable<Usuario> findAllUsuario();
	public Page<Usuario> findAllUsuario(Pageable pageable);
	public Optional<Usuario> findByIdUsuario(int id);
	public void deleteByIdUsuario(int id);
	public String Autenticarusuario(String email, String contrasena);
	
	// TipoUsuario
	public TipoUsuario saveTipoUsuario(TipoUsuario tipoUsuario);
	public Iterable<TipoUsuario> findAllTipoUsuario();
	public Page<TipoUsuario> findAllTipoUsuario(Pageable pageable);
	public Optional<TipoUsuario> findByIdTipoUsuario(int id);
	public void deleteByIdTipoUsuario(int id);	
	
	// TipoServicio
	public TipoServicio saveTipoServicio(TipoServicio tipoServicio);
	public Iterable<TipoServicio> findAllTipoServicio();
	public Page<TipoServicio> findAllTipoServicio(Pageable pageable);
	public Optional<TipoServicio> findByIdTipoServicio(int id);
	public void deleteByIdTipoServicio(int id);
	
	// Servicio
	public String saveServicio(Servicio servicio);
	public Iterable<Servicio> findAllServicio();
	public Page<Servicio> findAllServicio(Pageable pageable);
	public Optional<Servicio> findByIdServicio(int id);
	public void deleteByIdServicio(int id);

	// Comentario
	public Comentario saveComentario(Comentario comentario);
	public Iterable<Comentario> findAllComentario();
	public Page<Comentario> findAllComentario(Pageable pageable);
	public Optional<Comentario> findByIdComentario(int id);
	public void deleteByIdComentario(int id);
	
	// Cita
	public Cita saveCita(Cita cita);
	public Iterable<Cita> findAllCita();
	public Page<Cita> findAllCita(Pageable pageable);
	public Optional<Cita> findByIdCita(int id);
	public void deleteByIdCita(int id);
	
	

}
