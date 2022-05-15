package curso.java.tienda.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.model.Configuracion;

@Controller
@RequestMapping("/configuracion")
public class ConfiguracionController {
	
	@GetMapping("/list")
	public String configuracionList(Model model) {
		
		ArrayList<Configuracion> lista = new ArrayList<Configuracion>();
		lista.add (new Configuracion(0, "numero.factura","1","Numero"));
		lista.add (new Configuracion(1, "nombre.empresa","serbatic","Texto"));
		lista.add (new Configuracion(2, "direccion.empresa","avda. tres cantos","Texto"));
		lista.add (new Configuracion(3, "provincia.empresa","Madrid","Texto"));
		
		model.addAttribute("lista", lista);
		return("/configuracion/list");
	}
		

	@GetMapping("/form/{id}")
	public String configuracionDetalle(@PathVariable("id") int id, Model model) {
		
		ArrayList<Configuracion> lista = new ArrayList<Configuracion>();
		lista.add (new Configuracion(0, "numero.factura","1","Numero"));
		lista.add (new Configuracion(1, "nombre.empresa","serbatic","Texto"));
		lista.add (new Configuracion(2, "direccion.empresa","avda. tres cantos","Texto"));
		lista.add (new Configuracion(3, "provincia.empresa","Madrid","Texto"));
		Configuracion configuracion = lista.get(id);
		
		model.addAttribute("tipoFormulario", 1);
		model.addAttribute("configuracion", configuracion);
		return("/configuracion/form");
	}	
	
	@GetMapping("/form")
	public String configuracionFormulario(Model model) {
		
		Configuracion configuracion = new Configuracion();
		
		model.addAttribute("tipoFormulario", 2);
		model.addAttribute("configuracion", configuracion);
		return("/configuracion/form");
	}
	
	@PostMapping("/update")
	public String configuracionUpdate(@ModelAttribute Configuracion configuracion) {
		
		//TODO: CON EL OBJETO PRODUCTO HARIA EL UPDATE EN EL MODELO Y VUELVO A MOSTRAR EL MISMO OBJETO EN EL FORMULARIO
		System.out.println("entra en update: "+configuracion.getClave()+" + "+configuracion.getValor()+" + "+configuracion.getTipo());
		
		return("redirect:/configuracion/form/"+configuracion.getId());
	}
	
	
	@PostMapping("/save")
	public String configuracionSave(@ModelAttribute Configuracion configuracion) {
		
		//TODO: CON EL OBJETO PRODUCTO HARIA EL UPDATE EN EL MODELO Y VUELVO A MOSTRAR EL MISMO OBJETO EN EL FORMULARIO
		System.out.println("entra en update: "+configuracion.getClave()+" + "+configuracion.getValor()+" + "+configuracion.getTipo());
		
		
		return("redirect:/configuracion/list/");
	}
	
	
	
	

}
