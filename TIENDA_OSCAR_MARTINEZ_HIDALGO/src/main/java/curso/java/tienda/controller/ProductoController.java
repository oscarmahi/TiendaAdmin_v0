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
import curso.java.tienda.model.Producto;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@GetMapping("/list")
	public String productoList(Model model) {
		
		Categorias categoria = new Categorias(1,"bicicletas", "");
		ArrayList<Producto> lista = new ArrayList<Producto>();
		lista.add (new Producto(0,categoria, "uno", "", 100.2, 10,	"", "", 10, "", 0));
		lista.add (new Producto(1,categoria, "dos", "", 100.2, 10,	"", "", 20, "", 0));
		lista.add (new Producto(2,categoria, "tres", "", 100.2, 10,	"", "", 30, "", 0));
		lista.add (new Producto(3,categoria, "cuatro", "", 100.2, 10,	"", "", 40, "", 0));
		lista.add (new Producto(4,categoria, "cinco", "", 100.2, 10,	"", "", 50, "", 0));
		
		model.addAttribute("lista", lista);
		return("/producto/list");
	}
	
	@GetMapping("/form/{id}")
	public String productoDetalle(@PathVariable("id") int id, Model model) {
		
		Categorias categoria = new Categorias(1,"bicicletas", "");
		ArrayList<Producto> lista = new ArrayList<Producto>();
		lista.add (new Producto(0,categoria, "uno", "", 100.2, 10,	"", "", 10, "", 0));
		lista.add (new Producto(1,categoria, "dos", "", 100.2, 10,	"", "", 20, "", 0));
		lista.add (new Producto(2,categoria, "tres", "", 100.2, 10,	"", "", 30, "", 0));
		lista.add (new Producto(3,categoria, "cuatro", "", 100.2, 10,	"", "", 40, "", 0));
		lista.add (new Producto(4,categoria, "cinco", "", 100.2, 10,	"", "", 50, "", 0));
		Producto producto = lista.get(id);
		
		model.addAttribute("tipoFormulario", 1);
		model.addAttribute("producto", producto);
		return("/producto/form");
	}

	@GetMapping("/form")
	public String productoVacio(Model model) {
		
		Producto producto = new Producto();;
		
		model.addAttribute("tipoFormulario", 2);
		model.addAttribute("producto", producto);
		return("/producto/form");
	}
	
	@PostMapping("/update")
	public String productoUpdate(@ModelAttribute Producto producto) {
		
		//TODO: CON EL OBJETO PRODUCTO HARIA EL UPDATE EN EL MODELO Y VUELVO A MOSTRAR EL MISMO OBJETO EN EL FORMULARIO
		System.out.println("entra en update: "+producto.getNombre()+" + "+producto.getId());
		
		return("redirect:/producto/form/"+producto.getId());
	}
	
	@PostMapping("/save")
	public String productoSave(@ModelAttribute Producto producto) {
		
		//TODO:RECOGER LOS DATOS DEL PRODUCTO, LLAMAR AL MODELO PARA GRABAR Y VUELVO A MOSTRAR LA LISTA DE PRODUCTOS
		
		System.out.println("entra en save: "+producto.getNombre()+" + "+producto.getCategorias().getNombre()+""+producto.getDescripcion());
		
		
		return("redirect:/producto/list/");
	}
	

}
