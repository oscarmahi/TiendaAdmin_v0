package curso.java.tienda.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne (cascade = CascadeType.ALL)
	private Usuarios usuario;
	
	private String fecha;
	
	private String metodo_pago;
	
	private String estado;
	
	private String num_factura;
	
	private Double total;
	
	 /**
	  * ‘pendiente envío’ (PE), ‘pendiente cancelación’ (PC), ‘enviado’ (E) o ‘cancelado’ (C)
	  * 
	  */
	
	public Pedido(int id, Usuarios usuario, String fecha, String metodo_pago, String estado, String num_factura, Double total) {
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.metodo_pago = metodo_pago;
		this.estado = estado;
		this.num_factura = num_factura;
		this.total = total;
	}

	
	public Pedido(Usuarios usuario, String fecha, String metodo_pago, String estado, String num_factura, Double total) {
		this.usuario = usuario;
		this.fecha = fecha;
		this.metodo_pago = metodo_pago;
		this.estado = estado;
		this.num_factura = num_factura;
		this.total = total;
	}
	
	public Pedido() {
		
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}


	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMetodo_pago() {
		return metodo_pago;
	}

	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNum_factura() {
		return num_factura;
	}

	public void setNum_factura(String num_factura) {
		this.num_factura = num_factura;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	

}
