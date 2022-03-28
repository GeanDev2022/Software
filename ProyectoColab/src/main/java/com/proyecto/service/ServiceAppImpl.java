package com.proyecto.service;

import java.util.ArrayList;
import java.util.List;
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
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
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

	@Override
	public List<Object> autenticateUsuario(String email, String password) {

		int numero = 0;
		List<Object> lista = new ArrayList<Object>();
		try {

			StoredProcedureQuery storedProcedureQuery = entityManager
					.createStoredProcedureQuery("BASEDEDATOS.autenticateUser");

			// Registrar los parámetros de entrada y salida
			storedProcedureQuery.registerStoredProcedureParameter("parametro1", String.class, ParameterMode.IN);
			storedProcedureQuery.registerStoredProcedureParameter("parametro2", String.class, ParameterMode.IN);

			// Configuramos el valor de entrada
			storedProcedureQuery.setParameter("parametro1", email);
			storedProcedureQuery.setParameter("parametro2", password);

			// Realizamos la llamada al procedimiento
			storedProcedureQuery.execute();

			lista = storedProcedureQuery.getResultList();

		} catch (Exception ex) {
			System.out.println(ex.toString());
			numero = -1;
		}
		return lista;
	}
	
	// ---------------------------------------TipoUsuario------------------------------------
	@Override
	public TipoUsuario saveTipoUsuario(TipoUsuario tipoUsuario) {
		return tipoUsuarioRepository.save(tipoUsuario);
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
	public TipoServicio saveTipoServicio(TipoServicio tipoServicio) {
		return tipoServicioRepository.save(tipoServicio);
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
	public Servicio saveServicio(Servicio servicio) {
		return servicioRepository.save(servicio);
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
	public Comentario saveComentario(Comentario comentario) {
		return comentarioRepository.save(comentario);
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
	public Cita saveCita(Cita cita) {
		return citaRepository.save(cita);
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
