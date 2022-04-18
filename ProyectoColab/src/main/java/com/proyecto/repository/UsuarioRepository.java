package com.proyecto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import com.proyecto.entity.TipoUsuario;
import com.proyecto.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{


	@Procedure(procedureName = "autenticarusuario")
	String Procedureautenticarusuario(String email, String contrasena);
	
	
	@Procedure(procedureName = "crearusuario")
	String ProcedureinsertarUsuario(int cedulapersona, int celularpersona, String direccionpersona,
			int edadpersona, String nombrepersona, String contrasenapersona, String emailusuario, int tipoUsuario);
	
	@Procedure(procedureName = "modificarusuario")
	String ProceduremodificarUsuario( int cedulapersona, int celularpersona, String direccionpersona,String nombrepersona, String contrasenapersona, String emailusuario, int tipoUsuario);
	
	@Procedure(procedureName = "eliminarusuario")
	String ProcedureeliminarUsuario(int personaId);
	
	@Procedure(procedureName = "buscarusuario")
	String ProcedureBuscarUsuario(int cedulapersona);
	
}
