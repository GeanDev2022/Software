package com.proyecto.repository;


import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import com.proyecto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Procedure(procedureName = "autenticarusuario")
	String Procedureautenticarusuario(String email, String contrasena);

	@Procedure(procedureName = "crearusuario")
	String ProcedureinsertarUsuario(int cedulapersona, int celularpersona, String direccionpersona, int edadpersona,
			String nombrepersona, String contrasenapersona, String emailusuario, int tipoUsuario);

	@Procedure(procedureName = "modificarusuario")
	String ProceduremodificarUsuario(int cedulapersona, int celularpersona, String direccionpersona,
			String nombrepersona, String contrasenapersona, String emailusuario, int tipoUsuario);

	@Procedure(procedureName = "eliminarusuario")
	String ProcedureeliminarUsuario(int personaId);

	@Procedure(procedureName = "buscarusuario")
	String ProcedureBuscarUsuario(int cedulapersona);

	@Procedure(procedureName = "doctortopcalificado")
	String ProcedureListarDoctorTopCalificado();

	@Procedure(name = "em.ProcedureListarDoctores") 
	Map<String, ?> ProcedureListarDoctores();
	
	@Procedure(name = "em.ProcedureListarCitasUsuarios") 
	Map<String, ?> ProcedureListarCitasUsuarios(int person_id);
	
	@Procedure(name = "em.ProcedureListarCitasUsuariosComplete") 
	Map<String, ?> ProcedureListarCitasUsuariosComplete(int person_id);
	

}
