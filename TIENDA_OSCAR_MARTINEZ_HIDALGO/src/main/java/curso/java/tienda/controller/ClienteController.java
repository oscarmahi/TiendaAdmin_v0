package curso.java.tienda.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.model.Roles;
import curso.java.tienda.model.Usuarios;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@GetMapping("/list")
	public String clienteList(Model model) {
		
		Roles rol = new Roles(1,"cliente");
		Roles rolE = new Roles(1,"empleado");
		Roles rolA = new Roles(1,"administrador");
		
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		lista.add (new Usuarios(0,rol, "email0", "clave0", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(1,rol, "email1", "clave1", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(2,rol, "email2", "clave2", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(3,rol, "email3", "clave3", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(4,rol, "email4", "clave4", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(5,rol, "email5", "clave5", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(6,rolA, "admin@gmail.com", "clave5", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(7,rolE, "empleado@gmail.com", "clave5", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		
		model.addAttribute("lista", lista);
		return("/cliente/list");
	}
	
	@GetMapping("/form/{id}")
	public String clienteDetalle(@PathVariable("id") int id, Model model) {
		Roles rol = new Roles(1,"cliente");
		Roles rolE = new Roles(1,"empleado");
		Roles rolA = new Roles(1,"administrador");
		
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		lista.add (new Usuarios(0,rol, "email0", "clave0", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(1,rol, "email1", "clave1", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(2,rol, "email2", "clave2", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(3,rol, "email3", "clave3", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(4,rol, "email4", "clave4", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(5,rol, "email5", "clave5", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(6,rolA, "admin@gmail.com", "clave5", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
		lista.add (new Usuarios(7,rolE, "empleado@gmail.com", "clave5", "nombre","apelli1","apelli2", "dir", "prov", "loca", "telef","dni"));
	
		Usuarios usuarios = lista.get(id);
		
		model.addAttribute("tipoFormulario", 1);
		model.addAttribute("usuarios", usuarios);
		return("/cliente/form");
	}

	@GetMapping("/form")
	public String clienteVacio(Model model) {
		
		Usuarios usuarios = new Usuarios();
		
		model.addAttribute("tipoFormulario", 2);
		model.addAttribute("usuarios", usuarios);
		return("/cliente/form");
	}
	
	@PostMapping("/update")
	public String clienteUpdate(@ModelAttribute Usuarios usuarios) {
		
		//TODO: CON EL OBJETO PRODUCTO HARIA EL UPDATE EN EL MODELO Y VUELVO A MOSTRAR EL MISMO OBJETO EN EL FORMULARIO
		System.out.println("entra en update: "+usuarios.getNombre()+" + "+usuarios.getId()+" + "+usuarios.getRoles().getRol());
		
		return("redirect:/cliente/form/"+usuarios.getId());
	}
	
	@PostMapping("/save")
	public String clienteSave(@ModelAttribute Usuarios usuarios) {
		
		//TODO:RECOGER LOS DATOS DEL PRODUCTO, LLAMAR AL MODELO PARA GRABAR Y VUELVO A MOSTRAR LA LISTA DE PRODUCTOS
		
		System.out.println("entra en save: "+usuarios.getNombre()+" + "+usuarios.getApellido1()+" + "+usuarios.getRoles().getRol());
		
		
		return("redirect:/cliente/list/");
	}
	



	
	
	

}
