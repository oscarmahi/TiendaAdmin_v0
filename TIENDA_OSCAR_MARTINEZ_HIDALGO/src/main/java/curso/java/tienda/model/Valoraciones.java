package curso.java.tienda.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="valoraciones")
public class Valoraciones {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private Producto producto;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private Usuarios usuario;
	
	private int valoracion;
	
	private String comentario;
	
	public Valoraciones(int id, Producto producto, Usuarios usuario, int valoracion, String comentario) {
		this.id = id;
		this.producto = producto;
		this.usuario = usuario;
		this.valoracion = valoracion;
		this.comentario = comentario;
	}
	
	public Valoraciones(Producto producto, Usuarios usuario, int valoracion, String comentario) {
		this.producto = producto;
		this.usuario = usuario;
		this.valoracion = valoracion;
		this.comentario = comentario;
	}
	
	public Valoraciones() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	
	

}
