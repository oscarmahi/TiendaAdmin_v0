package curso.java.tienda.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

//import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Roles;
import curso.java.tienda.model.Usuarios;
import curso.java.tienda.service.UsuarioService;

@Controller
@RequestMapping("")
public class InitialController {
	
	@GetMapping("")
	public String index() {
		return("index");
	}

//	@GetMapping("/index")
//	public String index1() {
//		return("index");
//	}
	
	
//	@GetMapping("/producto/list")
//	public String producto() {
//		return("/producto/list");
//
//	}
	
//	@GetMapping("/catalogo")
//	public String catalogo() {		
//		return("catalogo");
//	}
	
//	@GetMapping("/usuario/list")
//	public String usuarios() {
//		return("/usuario/list");
//	}

	@PostMapping("/login")
	public String login(Model model, @RequestParam String usuario, @RequestParam String password, HttpSession misesion) {
		
		//misesion.setAttribute("nombre", null);  Borro la sesion del usuario
		//model.addAttribute("rol", 1);
		//misesion.removeAttribute("rol");
		if ((usuario.length() != 0) && (password.length()) != 0){
			
			//TODO: EN LA CAPA SERVICIO VALIDAR EL FORMATO DEL EMAIL ANTES DE IR AL MODELO
			
		    //Usuarios usuarioM = new UsuarioService().findByUsuarioUsuario(usuario);
		    
			Roles rolE = new Roles(3, "empleado");
			Roles rolA = new Roles(4, "administrador");
		    Usuarios usuarioM = new Usuarios(6, rolA,usuario, password,"","","","","","","","");
		    //Usuarios usuarioM = new Usuarios(7, rolE,usuario, password,"","","","","","","","");

			if (usuarioM != null) {
				//StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
				//if (passwordEncryptor.checkPassword(usuario, usuarioM.getClave())) {
				
				if (true) {	
					misesion.setAttribute("usuarioSesion", usuarioM); 
				}
			}
		}
		return "index";
		
	}
}