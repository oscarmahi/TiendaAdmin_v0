package curso.java.tienda.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalles_pedido")
public class Detalles_Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private Pedido pedido;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private Producto producto;
	
	private float precio_unidad;
	
	private int unidades;
	
	private float impuesto;
	
	private double total;
	
	public Detalles_Pedido(int id, Pedido pedido, Producto producto, float precio_unidad, int unidades, float impuesto,
			double total) {
		this.id = id;
		this.pedido = pedido;
		this.producto = producto;
		this.precio_unidad = precio_unidad;
		this.unidades = unidades;
		this.impuesto = impuesto;
		this.total = total;
	}
	
	public Detalles_Pedido(Pedido pedido, Producto producto, float precio_unidad, int unidades, float impuesto,
			double total) {
		this.pedido = pedido;
		this.producto = producto;
		this.precio_unidad = precio_unidad;
		this.unidades = unidades;
		this.impuesto = impuesto;
		this.total = total;
	}
	
	public Detalles_Pedido() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public float getPrecio_unidad() {
		return precio_unidad;
	}

	public void setPrecio_unidad(float precio_unidad) {
		this.precio_unidad = precio_unidad;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public float getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	

}
