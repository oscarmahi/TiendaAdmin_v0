package curso.java.tienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="configuracion")
public class Configuracion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String clave;
	
	private String valor;
	
	private String tipo;
	
	public Configuracion(int id, String clave, String valor, String tipo) {
		this.id = id;
		this.clave = clave;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public Configuracion(String clave, String valor, String tipo) {
		this.clave = clave;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public Configuracion() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
