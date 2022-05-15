package curso.java.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Usuarios;
import curso.java.tienda.repository.IUsuariosRepository;

@Service
public class UsuarioService{

	@Autowired
	private IUsuariosRepository usuarioRepo;


	public List<Usuarios> findAll() {

		return usuarioRepo.findAll();	
	}

	public Optional<Usuarios> findById(int id) {

		return usuarioRepo.findById(id);
	}


	public Usuarios create(Usuarios usuarios) {

		return usuarioRepo.save(usuarios);
	}


	public Usuarios update(Usuarios usuarios) {

		return usuarioRepo.save(usuarios);
	}


	public void delete(int id) {

		usuarioRepo.deleteById(id);
	}

//
//	public List<Usuarios> findByApellido1(String apellido1) {
//		return usuarioRepo.findByApellido1(apellido1);
//	}
//
//	public List<Usuarios> findByUsuario(String email) {
//		return usuarioRepo.findByUsuario(email);
//	}
//
//	public Usuarios findByUsuarioPassword(String email, String clave) {
//		return usuarioRepo.findByUsuarioPassword(email, clave);
//	}


	public Usuarios findByUsuarioUsuario(String email) {
		
		Usuarios u = usuarioRepo.findByUsuarioUsuario(email);
		System.out.println("EN usuarioservice"+u.getEmail());
		
		return usuarioRepo.findByUsuarioUsuario(email);
	}
			
		
	
	
	
}
