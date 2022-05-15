package curso.java.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import curso.java.tienda.model.Usuarios;

//public interface IUsuariosRepository extends CrudRepository<Usuarios, Integer>{
public interface IUsuariosRepository extends JpaRepository<Usuarios, Integer>{
	
//	@Query("SELECT u FROM Usuarios u WHERE u.apellido1 LIKE %?1%")
//	public List<Usuarios> findByApellido1(String apellido1);		
//	
//	@Query("SELECT u FROM Usuarios u WHERE u.email LIKE %?1%")
//	public List<Usuarios> findByUsuario(String email);		
//	
//	@Query("SELECT u FROM Usuarios u WHERE u.email =?1 and u.clave = ?2")
//	public Usuarios findByUsuarioPassword(String email, String clave);		

	@Query("SELECT u FROM Usuarios u WHERE u.email =?1")
	public Usuarios findByUsuarioUsuario(String email);		
	
	
	//@Query("SELECT u.usuario, u.password, r.rol FROM Usuarios u, Roles r WHERE u.usuario =?1 and u.password = ?2 and u.roles=r.id")
	//public String findByUsuarioPassword(String usuario, String password);		
	
	
	//SELECT u.usuario, u.password, r.rol FROM Usuarios u , Roles r WHERE u.usuario ='oscarmahi@gmail.com'
	//		and u.password = 'oscar' and u.roles_id=r.id	
	
	

}
