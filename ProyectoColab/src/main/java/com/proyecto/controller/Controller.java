package com.proyecto.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Cita;
import com.proyecto.entity.Comentario;
import com.proyecto.entity.Servicio;
import com.proyecto.entity.TipoServicio;
import com.proyecto.entity.TipoUsuario;
import com.proyecto.entity.Usuario;
import com.proyecto.service.ServiceApp;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

	// -----------------------------//
	// Usuario---------------------------------------------------
	@Autowired(required = true)
	private ServiceApp services;

	/**
	 * Sirve para registrar/crear un usuario
	 * 
	 * @param usuario
	 * @return
	 */
	@PostMapping("/registroUsuario")
	public ResponseEntity<?> registroUsuario(@RequestBody Usuario usuario) {
	
		if (usuario.getCedulaPersona() != 0 && !services.findByIdUsuario(usuario.getCedulaPersona()).isPresent()) {
			if (services.saveUsuario(usuario) != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(services.saveUsuario(usuario));
			}

		}
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED);

	}
	
	/**
	 * 	@PostMapping("/registroServicio")
	public ResponseEntity<?> registroServicio(@RequestBody Servicio servicio) {
		return ResponseEntity.status(HttpStatus.CREATED).body(services.saveServicio(servicio));
	}
	 */

	
	
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	@PostMapping("/autenticarUsuario")
	public String autenticarUsuario(@RequestBody Usuario usuario) {

		return services.Autenticarusuario(usuario.getEmailUsuario(), usuario.getContrasenaUsuario());
	}

	@DeleteMapping("/borrarUsuario/{id}")
	public ResponseEntity<?> borrarUsuario(@PathVariable(value = "id") int usuarioId) {

		if (!services.findByIdUsuario(usuarioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		services.deleteByIdUsuario(usuarioId);
		return ResponseEntity.ok().build();
	}

	/**
	 * Sirve para actualizar usuario
	 * 
	 * @param userDetails
	 * @param userId
	 * @return
	 */
	@PutMapping("/actualizarUsuario/{id}")
	public ResponseEntity<?> updateUser(@RequestBody Usuario detalleUsuario,
			@PathVariable(value = "id") int usuarioId) {

		Optional<Usuario> usuario = services.findByIdUsuario(usuarioId);

		if (!services.findByIdUsuario(usuarioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		usuario.get().setPersonaId(detalleUsuario.getPersonaId());
		usuario.get().setCedulaPersona(detalleUsuario.getCedulaPersona());
		usuario.get().setNombrePersona(detalleUsuario.getNombrePersona());
		usuario.get().setEdadPersona(detalleUsuario.getEdadPersona());
		usuario.get().setDireccionPersona(detalleUsuario.getDireccionPersona());
		usuario.get().setCelularPersona(detalleUsuario.getCelularPersona());
		usuario.get().setEmailUsuario(detalleUsuario.getEmailUsuario());
		usuario.get().setContrasenaUsuario(detalleUsuario.getContrasenaUsuario());

		return ResponseEntity.status(HttpStatus.CREATED).body(services.saveUsuario(usuario.get()));

	}

	/**
	 * Sirve para Leer un usuario
	 * 
	 * @param usuarioId
	 * @return
	 */
	@GetMapping("/leerUsuario/{id}")
	public ResponseEntity<?> leerUsuario(@PathVariable(value = "id") int usuarioId) {

		Optional<Usuario> usuario = services.findByIdUsuario(usuarioId);
		if (!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(usuario);

	}

	/**
	 * Listar todos los usuarios
	 * 
	 * @return
	 */
	@GetMapping("/listarUsuarios")
	public List<Usuario> leerTodosUsuarios() {

		List<Usuario> usuarios = StreamSupport.stream(services.findAllUsuario().spliterator(), false)
				.collect(Collectors.toList());

		return usuarios;
	}

	// -----------------------------TipoUsuario---------------------------------------------------
	/**
	 * Sirve para registrar/crear un tipo de usuario
	 * 
	 * @param tipoUsuario
	 * @return
	 */
	@PostMapping("/registroTipoUsuario")
	public ResponseEntity<?> registroTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {		
		if (tipoUsuario.getTipoUsuarioId() != 0 && !services.findByIdTipoUsuario(tipoUsuario.getTipoUsuarioId()).isPresent()) {
			if (services.saveTipoUsuario(tipoUsuario) != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(services.saveTipoUsuario(tipoUsuario));
			}

		}
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED);

	}
	
	/**
	 * Sirve para eliminar un tipo de usuario
	 * 
	 * @param tipoUsuarioId
	 * @return
	 */
	@DeleteMapping("/borrarTipoUsuario/{id}")
	public ResponseEntity<?> borrarTipoUsuario(@PathVariable(value = "id") int tipoUsuarioId) {

		if (!services.findByIdTipoUsuario(tipoUsuarioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		services.deleteByIdTipoUsuario(tipoUsuarioId);
		return ResponseEntity.ok().build();
	}

	/**
	 * Sirve para actualizar un tipo de usuario
	 * 
	 * @param detallesTipoUsuario
	 * @param tipoUsuarioId
	 * @return
	 */
	@PutMapping("/actualizarTipoUsuario/{id}")
	public ResponseEntity<?> actualizarTipoUsuario(@RequestBody TipoUsuario detallesTipoUsuario,
			@PathVariable(value = "id") int tipoUsuarioId) {

		Optional<TipoUsuario> tipoUsuario = services.findByIdTipoUsuario(tipoUsuarioId);

		if (!services.findByIdTipoUsuario(tipoUsuarioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		tipoUsuario.get().setTipoUsuarioId(detallesTipoUsuario.getTipoUsuarioId());
		tipoUsuario.get().setNombreTipoUsuario(detallesTipoUsuario.getNombreTipoUsuario());

		return ResponseEntity.status(HttpStatus.CREATED).body(services.saveTipoUsuario(tipoUsuario.get()));

	}

	/**
	 * Sirve para Leer un tipo de usuario
	 * 
	 * @param tipoUsuarioId
	 * @return
	 */
	@GetMapping("/leerTipoUsuario/{id}")
	public ResponseEntity<?> leerTipoUsuario(@PathVariable(value = "id") int tipoUsuarioId) {

		Optional<TipoUsuario> tipoUsuario = services.findByIdTipoUsuario(tipoUsuarioId);
		if (!tipoUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(tipoUsuario);

	}

	/**
	 * Listar todos los tipos de usuario
	 * 
	 * @return
	 */
	@GetMapping("/listarTiposUsuarios")
	public List<TipoUsuario> listarTiposUsuarios() {

		List<TipoUsuario> tipoUsuario = StreamSupport.stream(services.findAllTipoUsuario().spliterator(), false)
				.collect(Collectors.toList());

		return tipoUsuario;
	}

	// -----------------------------TipoServicio---------------------------------------------------
	/**
	 * Sirve para registrar/crear un tipo de usuario
	 * 
	 * @param tipoServicio
	 * @return
	 */
	@PostMapping("/registroTipoServicio")
	public ResponseEntity<?> registroTipoServicio(@RequestBody TipoServicio tipoServicio) {		
		if (tipoServicio.getTipoServicioId() != 0 && !services.findByIdTipoServicio(tipoServicio.getTipoServicioId()).isPresent()) {
			if (services.saveTipoServicio(tipoServicio) != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(services.saveTipoServicio(tipoServicio));
			}

		}
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * Sirve para eliminar un tipo de servicio
	 * 
	 * @param tipoUsuarioId
	 * @return
	 */
	@DeleteMapping("/borrarTipoServicio/{id}")
	public ResponseEntity<?> borrarTipoServicio(@PathVariable(value = "id") int tipoServicioId) {

		if (!services.findByIdTipoServicio(tipoServicioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		services.deleteByIdTipoServicio(tipoServicioId);
		return ResponseEntity.ok().build();
	}

	/**
	 * Sirve para actualizar un tipo de servicio
	 * 
	 * @param detallesTipoServicio
	 * @param tipoServicioId
	 * @return
	 */
	@PutMapping("/actualizarTipoServicio/{id}")
	public ResponseEntity<?> actualizarTipoServicio(@RequestBody TipoServicio detallesTipoServicio,
			@PathVariable(value = "id") int tipoServicioId) {

		Optional<TipoServicio> tipoServicio = services.findByIdTipoServicio(tipoServicioId);

		if (!services.findByIdTipoServicio(tipoServicioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		tipoServicio.get().setTipoServicioId(detallesTipoServicio.getTipoServicioId());
		tipoServicio.get().setNombreTipoServicio(detallesTipoServicio.getNombreTipoServicio());

		return ResponseEntity.status(HttpStatus.CREATED).body(services.saveTipoServicio(tipoServicio.get()));

	}

	/**
	 * Sirve para Leer un tipo de Servicio
	 * 
	 * @param tipoServicioId
	 * @return
	 */
	@GetMapping("/leerTipoServicio/{id}")
	public ResponseEntity<?> leerTipoServicio(@PathVariable(value = "id") int tipoServicioId) {

		Optional<TipoServicio> tipoServicio = services.findByIdTipoServicio(tipoServicioId);
		if (!tipoServicio.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(tipoServicio);

	}

	/**
	 * Listar todos los tipos de Servicio
	 * 
	 * @return
	 */
	@GetMapping("/listarTiposServicios")
	public List<TipoServicio> listarTiposServicios() {

		List<TipoServicio> tipoServicio = StreamSupport.stream(services.findAllTipoServicio().spliterator(), false)
				.collect(Collectors.toList());

		return tipoServicio;
	}

	// -----------------------------Servicio---------------------------------------------------

	/**
	 * Sirve para registrar/crear un Servicio
	 * 
	 * @param servicio
	 * @return
	 */
	@PostMapping("/registroServicio")
	public ResponseEntity<?> registroServicio(@RequestBody Servicio servicio) {
		if (servicio.getServicioId() != 0 && !services.findByIdServicio(servicio.getServicioId()).isPresent()) {
			if (services.saveServicio(servicio) != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(services.saveServicio(servicio));
			}

		}
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * Sirve para eliminar un Servicio
	 * 
	 * @param servicioId
	 * @return
	 */
	@DeleteMapping("/borrarServicio/{id}")
	public ResponseEntity<?> borrarServicio(@PathVariable(value = "id") int servicioId) {

		if (!services.findByIdServicio(servicioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		services.deleteByIdServicio(servicioId);
		return ResponseEntity.ok().build();
	}

	/**
	 * Sirve para actualizar un Servicio
	 * 
	 * @param detallesServicio
	 * @param servicioId
	 * @return
	 */
	/**
	 * @PutMapping("/actualizarServicio/{id}") public ResponseEntity<?>
	 * actualizarServicio(@RequestBody Servicio detallesServicio,
	 * 
	 * @PathVariable(value = "id") int servicioId) {
	 * 
	 *                     Optional<Servicio> servicio =
	 *                     services.findByIdServicio(servicioId);
	 * 
	 *                     if (!services.findByIdServicio(servicioId).isPresent()) {
	 *                     return ResponseEntity.notFound().build(); }
	 * 
	 *                     servicio.get().setServicioId(detallesServicio.getServicioId());
	 *                     servicio.get().setNombreServicio(detallesServicio.getNombreServicio());
	 * 
	 *                     return
	 *                     ResponseEntity.status(HttpStatus.CREATED).body(services.saveServicio(servicio.get()));
	 * 
	 *                     }
	 **/

	/**
	 * Sirve para Leer un Servicio
	 * 
	 * @param servicioId
	 * @return
	 */
	@GetMapping("/leerServicio/{id}")
	public ResponseEntity<?> leerServicio(@PathVariable(value = "id") int servicioId) {

		Optional<Servicio> servicio = services.findByIdServicio(servicioId);
		if (!servicio.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(servicio);

	}

	/**
	 * Listar todos los tipos de Servicio
	 * 
	 * @return
	 */
	@GetMapping("/listarServicios")
	public List<Servicio> listarServicios() {

		List<Servicio> servicio = StreamSupport.stream(services.findAllServicio().spliterator(), false)
				.collect(Collectors.toList());

		return servicio;
	}

	// -----------------------------Comentario---------------------------------------------------
	/**
	 * Sirve para registrar/crear un Comentario
	 * 
	 * @param comentario
	 * @return
	 */
	@PostMapping("/registroComentario")
	public ResponseEntity<?> registroComentario(@RequestBody Comentario comentario) {
		if (comentario.getComentarioId() != 0 && !services.findByIdComentario(comentario.getComentarioId()).isPresent()) {
			if (services.saveComentario(comentario) != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(services.saveComentario(comentario));
			}

		}
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED);

	}
	
	/**
	 * Sirve para eliminar un comentario
	 * 
	 * @param comentarioId
	 * @return
	 */
	@DeleteMapping("/borrarComentario/{id}")
	public ResponseEntity<?> borrarComentario(@PathVariable(value = "id") int comentarioId) {

		if (!services.findByIdComentario(comentarioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		services.deleteByIdComentario(comentarioId);
		return ResponseEntity.ok().build();
	}

	/**
	 * Sirve para actualizar un Comentario
	 * 
	 * @param detallesComentario
	 * @param comentarioId
	 * @return
	 */
	@PutMapping("/actualizarComentario/{id}")
	public ResponseEntity<?> actualizarComentario(@RequestBody Comentario detallesComentario,
			@PathVariable(value = "id") int comentarioId) {

		Optional<Comentario> comentario = services.findByIdComentario(comentarioId);

		if (!services.findByIdComentario(comentarioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		comentario.get().setComentarioId(detallesComentario.getComentarioId());
		comentario.get().setResenaComentario(detallesComentario.getResenaComentario());
		comentario.get().setCalificacion(detallesComentario.getCalificacion());

		return ResponseEntity.status(HttpStatus.CREATED).body(services.saveComentario(comentario.get()));

	}

	/**
	 * Sirve para Leer un Comentario
	 * 
	 * @param comentarioId
	 * @return
	 */
	@GetMapping("/leerComentario/{id}")
	public ResponseEntity<?> leerComentario(@PathVariable(value = "id") int comentarioId) {

		Optional<Comentario> comentario = services.findByIdComentario(comentarioId);
		if (!comentario.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(comentario);

	}

	/**
	 * Listar todos los comentario
	 * 
	 * @return
	 */
	@GetMapping("/listarComentarios")
	public List<Comentario> listarComentarios() {

		List<Comentario> comentario = StreamSupport.stream(services.findAllComentario().spliterator(), false)
				.collect(Collectors.toList());

		return comentario;
	}

	// -----------------------------Cita---------------------------------------------------
	/**
	 * Sirve para registrar/crear una Cita
	 * 
	 * @param comentario
	 * @return
	 */
	@PostMapping("/registroCita")
	public ResponseEntity<?> registroCita(@RequestBody Cita cita) {
		if (cita.getCitaId() != 0 && !services.findByIdCita(cita.getCitaId()).isPresent()) {
			if (services.saveCita(cita) != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(services.saveCita(cita));
			}

		}
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED);

	}

	/**
	 * Sirve para eliminar un Cita
	 * 
	 * @param citaId
	 * @return
	 */
	@DeleteMapping("/borrarCita/{id}")
	public ResponseEntity<?> borrarCita(@PathVariable(value = "id") int citaId) {

		if (!services.findByIdCita(citaId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		services.deleteByIdCita(citaId);
		return ResponseEntity.ok().build();
	}

	/**
	 * Sirve para actualizar un Cita
	 * 
	 * @param detallesCita
	 * @param citaId
	 * @return
	 */
	@PutMapping("/actualizarCita/{id}")
	public ResponseEntity<?> actualizarCita(@RequestBody Cita detallesCita, @PathVariable(value = "id") int citaId) {

		Optional<Cita> cita = services.findByIdCita(citaId);

		if (!services.findByIdCita(citaId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		cita.get().setCitaId(detallesCita.getCitaId());
		cita.get().setFechaCita(detallesCita.getFechaCita());
		cita.get().setDireccionCita(detallesCita.getDireccionCita());

		return ResponseEntity.status(HttpStatus.CREATED).body(services.saveCita(cita.get()));

	}

	/**
	 * Sirve para Leer un cita
	 * 
	 * @param citaId
	 * @return
	 */
	@GetMapping("/leerCita/{id}")
	public ResponseEntity<?> leerCita(@PathVariable(value = "id") int citaId) {

		Optional<Cita> cita = services.findByIdCita(citaId);
		if (!cita.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(cita);

	}

	/**
	 * Listar todos las Cita
	 * 
	 * @return
	 */
	@GetMapping("/listarCita")
	public List<Cita> listarCita() {

		List<Cita> cita = StreamSupport.stream(services.findAllCita().spliterator(), false)
				.collect(Collectors.toList());

		return cita;
	}

}
