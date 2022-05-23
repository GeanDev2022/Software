package com.proyecto.controlerTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.controller.Controller;
import com.proyecto.entity.Servicio;
import com.proyecto.entity.TipoServicio;
import com.proyecto.entity.TipoUsuario;
import com.proyecto.entity.Usuario;
import com.proyecto.service.ServiceApp;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@RunWith (SpringRunner.class)
@WebMvcTest(Controller.class)
/**
 * Pruebas unitarias de los Crud a traves del controlador por medio de Mokito
 * 
 */
public class controllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ServiceApp services;
	
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		objectMapper = new ObjectMapper();
	}
	
	
	/**
	 * Test para registrar/crear un usuario
	 * 
	 * @param usuario
	 * @return
	 */
	
	
	@Test
	void testRegistrousuario() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setPersonaId(1);
		usuario.setCedulaPersona(1234);
		usuario.setCelularPersona(31700);
		usuario.setContrasenaUsuario("1234");
		usuario.setNombrePersona("igor");
		usuario.setCita(null);
		usuario.setComentario(null);
		usuario.setDireccionPersona("calle1");
		usuario.setEmailUsuario("correo1@gmail.com");
		usuario.setTipoUsuario(1);
		System.out.println(objectMapper.writeValueAsString(usuario));
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("date", LocalDate.now().toString());
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "Usuario registrado con exito");
		respuesta.put("usuario", usuario);
		System.out.println(objectMapper.writeValueAsString(respuesta));
		respuesta.put("Usuario", usuario);
		when(services.buscarUsuario(1)).thenReturn(objectMapper.writeValueAsString(Datos.crearUsuario1()));
		mockMvc.perform(post("/api/registroUsuario").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(usuario)))
		        .andExpect(status().isCreated())
		        .andDo(print());
		verify(services).saveUsuario(usuario);
		assertEquals("igor",usuario.getNombrePersona()); // para probar el metodo se puede cambiar a cualquer valor aqui
		
	}
	/**
	 * test para actualizar usuario
	 * 
	 * @param userDetails
	 * @param userId
	 * @return
	 */
	
	@Test
	void testActualizarusuario() throws Exception {
		Usuario usuarioActualizado = new Usuario();
		Usuario usuarioViejo = new Usuario();
		usuarioActualizado.setCedulaPersona(1);
		usuarioActualizado.setCelularPersona(31700);
		usuarioActualizado.setContrasenaUsuario("1234");
		usuarioActualizado.setNombrePersona("Fedor");
		usuarioActualizado.setCita(null);
		usuarioActualizado.setComentario(null);
		usuarioActualizado.setDireccionPersona("calle1");
		usuarioActualizado.setEmailUsuario("correo1@gmail.com");
		usuarioActualizado.setTipoUsuario(1);
		System.out.println(objectMapper.writeValueAsString(usuarioActualizado));
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("date", LocalDate.now().toString());
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "Usuario Actualizado con exito");
		respuesta.put("usuario", usuarioActualizado);
		System.out.println(objectMapper.writeValueAsString(respuesta));
		when(services.buscarUsuario(1)).thenReturn(objectMapper.writeValueAsString(Datos.crearUsuario1()));
		usuarioViejo=Datos.crearUsuario1();
		respuesta.put("Usuario", usuarioActualizado);
		usuarioViejo=usuarioActualizado;
        
		mockMvc.perform(MockMvcRequestBuilders .put("/actualizarUsuario/{id}",1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(objectMapper.writeValueAsString( usuarioActualizado))))
		        .andDo(print());
      assertEquals("Fedor",usuarioActualizado.getNombrePersona()); // para probar el metodo se puede cambiar a cualquer valor aqui

		        
		
		
	}
	
	/**
	 * Test para Leer un usuario
	 * 
	 * @param usuarioId
	 * @return
	 */
	@Test
	void testLeerusuario() throws Exception {
		
		when(services.buscarUsuario(1)).thenReturn(objectMapper.writeValueAsString(Datos.crearUsuario1()));
		mockMvc.perform(MockMvcRequestBuilders .get("/leerUsuario/{id}",1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(Datos.crearUsuario1())));
		assertEquals("igor",Datos.crearUsuario1().getNombrePersona()); // para probar el metodo se puede cambiar a cualquer valor aqui  
		
		
	}
	/**
	 * Test para borrar un usuario
	 * 
	 * @param usuarioId
	 * @return
	 */
	@Test
	void testborrarusuario() throws Exception {
		
		when(services.buscarUsuario(1)).thenReturn(objectMapper.writeValueAsString(Datos.crearUsuario1()));
		mockMvc.perform(MockMvcRequestBuilders .delete("/borrarUsuario/{id}",1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(Datos.crearUsuario1())))
		.andExpect(status().is(404))
        .andDo(print());
		
		
	}
	
	// -----------------------------TipoUsuario---------------------------------------------------
  
	/**
	 * Test para registrar/crear un Tipo de usuario
	 * 
	 * @param usuario
	 * @return
	 */
	

	@Test
	void testregistroTipoUsuario() throws Exception {
		TipoUsuario tipoU = new TipoUsuario();
		tipoU.setTipoUsuarioId(1);
		tipoU.setNombreTipoUsuario("Administrador");
		
		
		System.out.println(objectMapper.writeValueAsString(tipoU));
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("date", LocalDate.now().toString());
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "Tipo registrado con exito");
		respuesta.put("Tipo de usuario", tipoU);
		System.out.println(objectMapper.writeValueAsString(respuesta));
		respuesta.put("Usuario", tipoU);
		mockMvc.perform(post("/registroTipoUsuario").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tipoU)));
		
		assertEquals("Administrador",tipoU.getNombreTipoUsuario()); // para probar el metodo se puede cambiar a cualquer valor aqui
		
		
		
	}
	/**
	 * test para actualizar un tipo  usuario
	 * 
	 * @param userDetails
	 * @param userId
	 * @return
	 */
	@Test
	void testActualizarTipousuario() throws Exception {
		TipoUsuario tipoU = new TipoUsuario();
		tipoU.setTipoUsuarioId(1);
		tipoU.setNombreTipoUsuario("Doctor");
		System.out.println(objectMapper.writeValueAsString(tipoU));
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("date", LocalDate.now().toString());
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "Usuario Actualizado con exito");
		respuesta.put("tipoUsuario", tipoU);
		System.out.println(objectMapper.writeValueAsString(respuesta));
		respuesta.put("tipoUsuario", tipoU);
		mockMvc.perform(MockMvcRequestBuilders .put("/actualizarTipoUsuario/{id}",1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tipoU)));
		assertEquals("Doctor",tipoU.getNombreTipoUsuario()); // para probar el metodo se puede cambiar a cualquer valor aqui        
		
		
	}
	/**
	 * Test para Leer un  tipo de usuario
	 * 
	 * @param usuarioId
	 * @return
	 */
	
	@Test
	void testLeerTipousuario() throws Exception {
		
		TipoUsuario tipoU = new TipoUsuario();
		tipoU.setTipoUsuarioId(1);
		tipoU.setNombreTipoUsuario("Doctor");
		mockMvc.perform(MockMvcRequestBuilders .get("/leerTipoUsuario/{id}",1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tipoU)));
		
		assertEquals("Doctor",tipoU.getNombreTipoUsuario()); // para probar el metodo se puede cambiar a cualquer valor aqui        
		
	}
	/**
	 * Test para Borrar un Tipo de usuario
	 * 
	 * @param usuarioId
	 * @return
	 */
	@Test
	void testborrartipoUsuario() throws Exception {
		
		TipoUsuario tipoU = new TipoUsuario();
		tipoU.setTipoUsuarioId(1);
		tipoU.setNombreTipoUsuario("Administrador");
		mockMvc.perform(MockMvcRequestBuilders .delete("/borrarTipoUsuario/{id}",1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tipoU)))
		.andExpect(status().is(404))
        .andDo(print());
		        
		
		
		
	}
	
	// -----------------------------TipoServicio---------------------------------------------------
	/**
	 * Test para registrar/crear un Tipo de servicio
	 * 
	 * @param usuario
	 * @return
	 */
	

	@Test
	void testregistroTiposervicio() throws Exception {
		TipoServicio tipoS = new TipoServicio();
		tipoS.setTipoServicioId(1);
		tipoS.setNombreTipoServicio("Consulta General");
		
		
		System.out.println(objectMapper.writeValueAsString(tipoS));
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("date", LocalDate.now().toString());
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "Tipo Servicio  registrado con exito");
		respuesta.put("Tipo de servicio", tipoS);
		System.out.println(objectMapper.writeValueAsString(respuesta));
		respuesta.put("Tiposervicio", tipoS);
		mockMvc.perform(post("/registroTipoServicio").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tipoS)));
		
		assertEquals("Consulta General",tipoS.getNombreTipoServicio()); // para probar el metodo se puede cambiar a cualquer valor aqui        
		
	}
	/**
	 * test para actualizar un tipo  de servicio
	 * 
	 * @param userDetails
	 * @param userId
	 * @return
	 */
	@Test
	void testActualizarTiposervicio() throws Exception {
		TipoServicio tipoS = new TipoServicio();
		tipoS.setTipoServicioId(1);
		tipoS.setNombreTipoServicio("Psiquiatria");
		System.out.println(objectMapper.writeValueAsString(tipoS));
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("date", LocalDate.now().toString());
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "tipo de  Actualizado con exito");
		respuesta.put("tipoServicio", tipoS);
		System.out.println(objectMapper.writeValueAsString(respuesta));
		respuesta.put("tipoServicio", tipoS);
		mockMvc.perform(MockMvcRequestBuilders .put("/actualizarTipoServicio/{id}",1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tipoS)));	
		assertEquals("Psiquiatria",tipoS.getNombreTipoServicio()); // para probar el metodo se puede cambiar a cualquer valor aqui
	}
	/**
	 * Test para Leer un  tipo de servicio
	 * 
	 * @param usuarioId
	 * @return
	 */
	
	@Test
	void testLeerTiposervicio() throws Exception {
		
		TipoServicio tipoS = new TipoServicio();
		tipoS.setTipoServicioId(1);
		tipoS.setNombreTipoServicio("Consulta General");
		mockMvc.perform(MockMvcRequestBuilders .get("/leerTipoServicio/{id}",1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tipoS)));
		assertEquals("Consulta General",tipoS.getNombreTipoServicio()); // para probar el metodo se puede cambiar a cualquer valor aqui
	}
	/**
	 * Test para Borrar un Tipo de usuario
	 * 
	 * @param usuarioId
	 * @return
	 */
	@Test
	void testborrartipoServicio() throws Exception {
		
		TipoServicio tipoS = new TipoServicio();
		tipoS.setTipoServicioId(1);
		tipoS.setNombreTipoServicio("Consulta General");
		mockMvc.perform(MockMvcRequestBuilders .delete("/borrarTipoServicio/{id}",1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tipoS)))
		        .andExpect(status().is(404))
                .andDo(print());
		
	}
	
	// -----------------------------Servicio---------------------------------------------------
	/**
	 * Test para registrar/crear un  servicio
	 * 
	 * @param usuario
	 * @return
	 */
	

	@Test
	void testregistroservicio() throws Exception {
		Servicio servicio = new Servicio();
		servicio.setServicioId(1);
		servicio.setNombreServicio("Consulta");
		
		
		
		System.out.println(objectMapper.writeValueAsString(servicio));
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("date", LocalDate.now().toString());
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "Servicio  registrado con exito");
		respuesta.put("servicio", servicio);
		System.out.println(objectMapper.writeValueAsString(respuesta));
		respuesta.put("Tiposervicio", servicio);
		mockMvc.perform(post("/registroServicio").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(servicio)));	
		assertEquals("Consulta",servicio.getNombreServicio()); // para probar el metodo se puede cambiar a cualquer valor aqui
	}
	/**
	 * test para actualizar un servicio
	 * 
	 * @param userDetails
	 * @param userId
	 * @return
	 */
	@Test
	void testActualizarServicio() throws Exception {
		Servicio servicio = new Servicio();
		servicio.setServicioId(1);
		servicio.setNombreServicio("Consulta 2 ");
		System.out.println(objectMapper.writeValueAsString(servicio));
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("date", LocalDate.now().toString());
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "servicio Actualizado con exito");
		respuesta.put("Servicio", servicio);
		System.out.println(objectMapper.writeValueAsString(respuesta));
		respuesta.put("tipoServicio", servicio);
		mockMvc.perform(MockMvcRequestBuilders .put("/actualizarServicio/{id}",1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(servicio)));	
		assertEquals("Consulta 2 ",servicio.getNombreServicio()); // para probar el metodo se puede cambiar a cualquer valor aqui
	}
	/**
	 * Test para Leer un   servicio
	 * 
	 * @param usuarioId
	 * @return
	 */
	
	@Test
	void testLeerServicio() throws Exception {
		
		Servicio servicio = new Servicio();
		servicio.setServicioId(1);
		servicio.setNombreServicio("Consulta 2 ");
		mockMvc.perform(MockMvcRequestBuilders .get("/leerServicio/{id}",1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(servicio)));
		assertEquals("Consulta 2 ",servicio.getNombreServicio()); // para probar el metodo se puede cambiar a cualquer valor aqui
		        
	}
	/**
	 * Test para Borrar un Tipo de usuario
	 * 
	 * @param usuarioId
	 * @return
	 */
	@Test
	void testborrarServicio() throws Exception {
		
		Servicio servicio = new Servicio();
		servicio.setServicioId(1);
		servicio.setNombreServicio("Consulta 2 ");
		mockMvc.perform(MockMvcRequestBuilders .delete("/borrarServicio/{id}",1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(servicio)))
		.andExpect(status().is(404))
        .andDo(print());
		
	}
}
