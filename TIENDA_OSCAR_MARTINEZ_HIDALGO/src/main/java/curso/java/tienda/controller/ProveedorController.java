package curso.java.tienda.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.model.Proveedores;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

	@GetMapping("/list")
	public String proveedorList(Model model) {
		
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		lista.add (new Proveedores(0,"proveedor0","direccion0","localidad0","provincia0","4234234","A454646","email0"));
		lista.add (new Proveedores(1,"proveedor1","direccion1","localidad1","provincia1","4234234","A454646","email1"));
		lista.add (new Proveedores(2,"proveedor2","direccion2","localidad2","provincia2","4234234","A454646","email2"));
		lista.add (new Proveedores(3,"proveedor3","direccion3","localidad3","provincia3","4234234","A454646","email3"));
		lista.add (new Proveedores(4,"proveedor4","direccion4","localidad4","provincia4","4234234","A454646","email4"));
		
		model.addAttribute("lista", lista);
		return("/proveedor/list");
	}
		

	@GetMapping("/form/{id}")
	public String proveedornDetalle(@PathVariable("id") int id, Model model) {

		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		lista.add (new Proveedores(0,"proveedor0","direccion0","localidad0","provincia0","4234234","A454646","email0"));
		lista.add (new Proveedores(1,"proveedor1","direccion1","localidad1","provincia1","4234234","A454646","email1"));
		lista.add (new Proveedores(2,"proveedor2","direccion2","localidad2","provincia2","4234234","A454646","email2"));
		lista.add (new Proveedores(3,"proveedor3","direccion3","localidad3","provincia3","4234234","A454646","email3"));
		lista.add (new Proveedores(4,"proveedor4","direccion4","localidad4","provincia4","4234234","A454646","email4"));
		Proveedores proveedores = lista.get(id);
		
		model.addAttribute("tipoFormulario", 1);
		model.addAttribute("proveedores", proveedores);
		return("/proveedor/form");
	}	
	
	@GetMapping("/form")
	public String proveedorFormulario(Model model) {
		
		Proveedores proveedores = new Proveedores();
		
		model.addAttribute("tipoFormulario", 2);
		model.addAttribute("proveedores", proveedores);
		return("/proveedor/form");
	}
	
	@PostMapping("/update")
	public String proveedorUpdate(@ModelAttribute Proveedores proveedores) {
		
		//TODO: CON EL OBJETO PRODUCTO HARIA EL UPDATE EN EL MODELO Y VUELVO A MOSTRAR EL MISMO OBJETO EN EL FORMULARIO
		System.out.println("entra en update: "+proveedores.getNombre()+" + "+proveedores.getEmail());
		
		return("redirect:/proveedor/form/"+proveedores.getId());
	}
	
	
	@PostMapping("/save")
	public String proveedoresSave(@ModelAttribute Proveedores proveedores) {
		
		//TODO: CON EL OBJETO PRODUCTO HARIA EL UPDATE EN EL MODELO Y VUELVO A MOSTRAR EL MISMO OBJETO EN EL FORMULARIO
		System.out.println("entra en update: "+proveedores.getNombre()+" + "+proveedores.getEmail());
		
		
		return("redirect:/proveedor/list/");
	}
	
	
		
	
	
	
	
}
