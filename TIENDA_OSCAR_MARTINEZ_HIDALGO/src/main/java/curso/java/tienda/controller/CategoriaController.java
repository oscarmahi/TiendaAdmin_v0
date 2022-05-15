package curso.java.tienda.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.model.Categorias;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@GetMapping("/list")
	public String categoriaList(Model model) {
		
		ArrayList<Categorias> lista = new ArrayList<Categorias>();
		lista.add (new Categorias(0,"bicicletas", "descripcion de la categoria de bicicletas"));
		lista.add (new Categorias(1,"ropa", "descripcion de la categoria de ropa"));
		lista.add (new Categorias(2,"accesorios", "descripcion de la categoria de accesorios"));
		lista.add (new Categorias(3,"herramientas", "descripcion de la categoria de herramientas"));
		
		model.addAttribute("lista", lista);
		return("/categoria/list");
	}
		

	@GetMapping("/form/{id}")
	public String categoriaDetalle(@PathVariable("id") int id, Model model) {
		
		ArrayList<Categorias> lista = new ArrayList<Categorias>();
		lista.add (new Categorias(0,"bicicletas", "descripcion de la categoria de bicicletas"));
		lista.add (new Categorias(1,"ropa", "descripcion de la categoria de ropa"));
		lista.add (new Categorias(2,"accesorios", "descripcion de la categoria de accesorios"));
		lista.add (new Categorias(3,"herramientas", "descripcion de la categoria de herramientas"));
		Categorias categorias = lista.get(id);
		
		model.addAttribute("tipoFormulario", 1);
		model.addAttribute("categorias", categorias);
		return("/categoria/form");
	}	
	
	@GetMapping("/form")
	public String categoriaFormulario(Model model) {
		
		Categorias categorias = new Categorias();
		
		model.addAttribute("tipoFormulario", 2);
		model.addAttribute("categorias", categorias);
		return("/categoria/form");
	}
	
	@PostMapping("/update")
	public String categoriaUpdate(@ModelAttribute Categorias categorias) {
		
		//TODO: CON EL OBJETO PRODUCTO HARIA EL UPDATE EN EL MODELO Y VUELVO A MOSTRAR EL MISMO OBJETO EN EL FORMULARIO
		System.out.println("entra en update: "+categorias.getNombre()+" + "+categorias.getDescripcion());
		
		return("redirect:/categoria/form/"+categorias.getId());
	}
	
	
	@PostMapping("/save")
	public String categoriaSave(@ModelAttribute Categorias categorias) {
		
		//TODO: CON EL OBJETO PRODUCTO HARIA EL UPDATE EN EL MODELO Y VUELVO A MOSTRAR EL MISMO OBJETO EN EL FORMULARIO
		System.out.println("entra en update: "+categorias.getNombre()+" + "+categorias.getDescripcion());
		
		
		return("redirect:/categoria/list/");
	}

}
