package curso.java.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.java.tienda.assistant.ExcelService;

@Controller
@RequestMapping("/auxiliar")
public class AuxiliarController {
	
	@GetMapping("/exceli")
	public String excelImportar() {
		
		System.out.println("importar excel");
		//boolean ok = new ExcelService().leerImportarExcel();

		return("index");
	}	

	@GetMapping("/excele")
	public String excelExportar() {
		
		System.out.println("exportar excel");
		//boolean ok = new ExcelService().escribirExcel();
		
		return("index");
	}	
	
}
