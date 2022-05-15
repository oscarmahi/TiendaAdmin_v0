package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class CerrarController {
	
	
	@GetMapping("/cerrar")
	public String cerrar(HttpSession misesion) {
		//misesion.removeAttribute("rol");
		misesion.removeAttribute("usuarioSesion");
		return("index");
	}

}
