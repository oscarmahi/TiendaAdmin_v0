package curso.java.tienda.assistant;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import curso.java.tienda.model.Categorias;
import curso.java.tienda.model.Producto;
//import curso.java.tienda.modelo.ProductoModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelService {

	public boolean escribirExcel() {

		boolean ok = true;

		// System.out.println("entra en escribir excel");
		//System.out.println("ficheros/productos.xls");
		
		File fichero = new File("./ficheros/productos.xls");

		//File fichero = new File("C:\\Users\\Formacion\\Documents\\CursoSerbatic\\workspaceCursoSerbaticSpring\\TIENDA_OSCAR_MARTINEZ_HIDALGO\\src\\main\\webapp\\ficheros\\productos.xls");

		ArrayList<Producto> lista = new ArrayList<Producto>();
		
		Categorias categoria = new Categorias(1,"bicicletas", "");
		lista.add (new Producto(0,categoria, "uno", "", 100.2, 10,	"", "", 10, "", 0));
		lista.add (new Producto(1,categoria, "dos", "", 100.2, 10,	"", "", 20, "", 0));
		lista.add (new Producto(2,categoria, "tres", "", 100.2, 10,	"", "", 30, "", 0));
		lista.add (new Producto(3,categoria, "cuatro", "", 100.2, 10,	"", "", 40, "", 0));
		lista.add (new Producto(4,categoria, "cinco", "", 100.2, 10,	"", "", 50, "", 0));
		
		
		
		//lista = new ProductoService().listarProductos();

		
		
		
		
		
		
		try {
			WritableWorkbook w = Workbook.createWorkbook(fichero);

			// Nombre de la hoja
			WritableSheet sheet = w.createSheet("Datos", 0);

			// columna fila contenido
			// jxl.write.Number number = new jxl.write.Number(0, 0, 1);
			// sheet.addCell(number);

			// jxl.write.Label cadena = new jxl.write.Label(1, 0, "valor");
			// sheet.addCell(cadena);

			jxl.write.Label texto = new jxl.write.Label(0, 0, "id");
			sheet.addCell(texto);

			texto = new jxl.write.Label(1, 0, "id_categoria");
			sheet.addCell(texto);

			texto = new jxl.write.Label(2, 0, "nombre");
			sheet.addCell(texto);

			texto = new jxl.write.Label(3, 0, "descripcion");
			sheet.addCell(texto);

			texto = new jxl.write.Label(4, 0, "precio");
			sheet.addCell(texto);

			texto = new jxl.write.Label(5, 0, "stock");
			sheet.addCell(texto);

			texto = new jxl.write.Label(6, 0, "fecha_alta");
			sheet.addCell(texto);

			texto = new jxl.write.Label(7, 0, "fecha_baja");
			sheet.addCell(texto);

			texto = new jxl.write.Label(8, 0, "impuesto");
			sheet.addCell(texto);

			for (int i = 0; i < lista.size(); i++) {
				texto = new jxl.write.Label(0, i + 1, lista.get(i).getId() + "");
				sheet.addCell(texto);

				texto = new jxl.write.Label(1, i + 1, lista.get(i).getCategorias() + "");
				sheet.addCell(texto);

				texto = new jxl.write.Label(2, i + 1, lista.get(i).getNombre());
				sheet.addCell(texto);

				texto = new jxl.write.Label(3, i + 1, lista.get(i).getDescripcion());
				sheet.addCell(texto);

				texto = new jxl.write.Label(4, i + 1, lista.get(i).getPrecio() + "");
				sheet.addCell(texto);

				texto = new jxl.write.Label(5, i + 1, lista.get(i).getStock() + "");
				sheet.addCell(texto);

				texto = new jxl.write.Label(6, i + 1, lista.get(i).getFecha_alta());
				sheet.addCell(texto);

				texto = new jxl.write.Label(7, i + 1, lista.get(i).getFecha_baja());
				sheet.addCell(texto);

				texto = new jxl.write.Label(8, i + 1, lista.get(i).getImpuesto() + "");
				sheet.addCell(texto);

			}
			w.write();
			w.close();

		} catch (Exception e) {
			System.out.println("Excepcion al escribor el fichero excel");
			e.printStackTrace();
		}

		return ok;
	}

	public boolean leerImportarExcel() {
		boolean ok = true;
	
		File archivoElegido=null;
		JFileChooser fc = new JFileChooser();
		//Mostrar la ventana para abrir archivo y recoger la respuesta
		//En el parámetro del showOpenDialog se indica la ventana
		//  al que estará asociado. Con el valor this se asocia a la
		//  ventana que la abre.
		int respuesta = fc.showOpenDialog(fc);
		//Comprobar si se ha pulsado Aceptar
		if (respuesta == JFileChooser.APPROVE_OPTION) {
		    //Crear un objeto File con el archivo elegido
		    archivoElegido = fc.getSelectedFile();
		    //Mostrar el nombre del archvivo en un campo de texto
		   // System.out.println("Archivo elegido: " + archivoElegido.getName());
			//File fichero = new File("C:\\Users\\Formacion\\Documents\\CursoSerbatic\\workspaceCursoSerbaticSpring\\TIENDA_OSCAR_MARTINEZ_HIDALGO\\src\\main\\webapp\\ficheros\\productosImportar.xls");
			try {
				//Workbook w = Workbook.getWorkbook(fichero);
				Workbook w = Workbook.getWorkbook(archivoElegido);

				// Se lee la primera hoja de la excel
				Sheet sheet = w.getSheet(0);
				leerExcel(sheet);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return ok;
	}

	public void leerExcel(Sheet sheet) throws Exception {
		String cadena;
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Producto producto = null;
		//System.out.println(sheet.getRows());
		for (int f = 0; f < sheet.getRows()-1; f++) {
			String contenido = " ";
			Categorias categoria = new Categorias(sheet.getCell(1, f+1).getContents(), "");
			producto = new Producto(
					categoria,
					sheet.getCell(2, f+1).getContents(),
					sheet.getCell(3, f+1).getContents(),
					Double.parseDouble(sheet.getCell(4, f+1).getContents()),
					Integer.parseInt(sheet.getCell(5, f+1).getContents()),
					sheet.getCell(6, f+1).getContents(),
					sheet.getCell(7, f+1).getContents(),
					Float.parseFloat(sheet.getCell(8, f+1).getContents()),
					null,
					0
					);
			lista.add(producto);
			
		}
		//for (ProductoVO productoVO : lista) {
		//	System.out.println(productoVO.getDescripcion());
		//}
		
		
		
		
		//boolean ok = new ProductoModel().grabarListaDeProductos(lista);
		
		
		
		
		
		
		
	}

}
