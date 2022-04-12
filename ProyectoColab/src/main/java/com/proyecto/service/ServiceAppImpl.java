package com.proyecto.service;

import java.util.Optional;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyecto.entity.Cita;
import com.proyecto.entity.Comentario;
import com.proyecto.entity.Servicio;
import com.proyecto.entity.TipoServicio;
import com.proyecto.entity.TipoUsuario;
import com.proyecto.entity.Usuario;
import com.proyecto.repository.CitaRepository;
import com.proyecto.repository.ComentarioRepository;
import com.proyecto.repository.ServicioRepository;
import com.proyecto.repository.TipoServicioRepository;
import com.proyecto.repository.TipoUsuarioRepository;
import com.proyecto.repository.UsuarioRepository;

@Service
public class ServiceAppImpl implements ServiceApp {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
	@Autowired
	private TipoServicioRepository tipoServicioRepository;
	@Autowired
	private ServicioRepository servicioRepository;
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	private CitaRepository citaRepository;

	private final EntityManager entityManager;

	@Autowired
	public ServiceAppImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// ---------------------------------------USER------------------------------------

	@Override
	@Transactional
	public String saveUsuario(Usuario usuario) {
		return usuarioRepository.ProcedureinsertarUsuario(usuario.getCedulaPersona(), usuario.getCelularPersona(),
				usuario.getDireccionPersona(), usuario.getEdadPersona(), usuario.getNombrePersona(),
				usuario.getContrasenaUsuario(), usuario.getEmailUsuario(), usuario.getTipoUsuario());
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAllUsuario() {
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAllUsuario(Pageable pageable) {
		return usuarioRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findByIdUsuario(int id) {
		return usuarioRepository.findById(id);
	}
	
	@Override
	@Transactional
	public void deleteByIdUsuario(int id) {
		usuarioRepository.deleteById(id);
	}

	public String Autenticarusuario(String email, String contrasena){
		return usuarioRepository.Procedureautenticarusuario(email, contrasena);
		
		
	}
	
	// ---------------------------------------TipoUsuario------------------------------------
	@Override
	public String saveTipoUsuario(TipoUsuario tipoUsuario) {
		return tipoUsuarioRepository.ProcedureinsertarTipoUsuario(tipoUsuario.getNombreTipoUsuario());
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<TipoUsuario> findAllTipoUsuario() {
		return tipoUsuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TipoUsuario> findAllTipoUsuario(Pageable pageable) {
		return tipoUsuarioRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TipoUsuario> findByIdTipoUsuario(int id) {
		return tipoUsuarioRepository.findById(id);
	}

	@Override
	public void deleteByIdTipoUsuario(int id) {
		tipoUsuarioRepository.deleteById(id);
	}
	
	// ---------------------------------------TipoServicio------------------------------------
	@Override
	public String saveTipoServicio(TipoServicio tipoServicio) {
		return tipoServicioRepository.ProcedureinsertarTipoServicio(tipoServicio.getNombreTipoServicio());
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<TipoServicio> findAllTipoServicio() {
		return tipoServicioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TipoServicio> findAllTipoServicio(Pageable pageable) {
		return tipoServicioRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TipoServicio> findByIdTipoServicio(int id) {
		return tipoServicioRepository.findById(id);
	}

	@Override
	public void deleteByIdTipoServicio(int id) {
		tipoServicioRepository.deleteById(id);
	}
	
	// ---------------------------------------Servicio------------------------------------

	@Override
	@Transactional
	public String saveServicio(Servicio servicio) {
		
		return servicioRepository.ProcedureinsertarServicio(servicio.getNombreServicio(), servicio.getPrecio(), servicio.getTipoServicio());
	}
	

	@Override
	@Transactional(readOnly = true)
	public Iterable<Servicio> findAllServicio() {
		return servicioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Servicio> findAllServicio(Pageable pageable) {
		return servicioRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Servicio> findByIdServicio(int id) {
		return servicioRepository.findById(id);
	}

	@Override
	public void deleteByIdServicio(int id) {
		servicioRepository.deleteById(id);
	}
	
	// ---------------------------------------Comentario------------------------------------
	@Override
	public String saveComentario(Comentario comentario) {
		return comentarioRepository.ProcedureinsertarComentario(comentario.getCalificacion(), comentario.getResenaComentario(), comentario.getUsuario());
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Comentario> findAllComentario() {
		return comentarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Comentario> findAllComentario(Pageable pageable) {
		return comentarioRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Comentario> findByIdComentario(int id) {
		return comentarioRepository.findById(id);
	}

	@Override
	public void deleteByIdComentario(int id) {
		comentarioRepository.deleteById(id);
	}
	
	// ---------------------------------------Cita------------------------------------
	@Override
	public String saveCita(Cita cita) {
		return citaRepository.ProcedureinsertarCita(cita.getDireccionCita(), cita.getFechaCita(), cita.getServicio(), cita.getUsuario());
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Cita> findAllCita() {
		return citaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cita> findAllCita(Pageable pageable) {
		return citaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cita> findByIdCita(int id) {
		return citaRepository.findById(id);
	}

	@Override
	public void deleteByIdCita(int id) {
		citaRepository.deleteById(id);
	}

}
