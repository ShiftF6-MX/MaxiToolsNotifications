package mx.shf6.notificacion.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DetalleRequisicion {
	
	//PROPIEDADES
	private StringProperty codigo;
	private StringProperty producto;
	private DoubleProperty cantidad;
	private StringProperty unidad;
	
	//CONSTRUCTORES
	public DetalleRequisicion() {
		this("", "", 0.0, "");
	}//FIN CONSTRUCTOR
	
	public DetalleRequisicion(String codigo, String producto, Double cantidad, String unidad) {
		this.codigo = new SimpleStringProperty(codigo);
		this.producto = new SimpleStringProperty(producto);
		this.cantidad = new SimpleDoubleProperty(cantidad);
		this.unidad = new SimpleStringProperty(unidad);
	}//FIN CONSTRUCTOR
	
	//METODOS
	public void setCodigo(String codigo) {
		this.codigo.set(codigo);
	}//FIN METODO
	
	public String getCodigo() {
		return this.codigo.get();
	}//FIN METODO
	
	public StringProperty codigoProperty() {
		return this.codigo;
	}//FIN METODO
	
	public void setProducto(String producto) {
		this.producto.set(producto);
	}//FIN METODO
	
	public String getProducto() {
		return this.producto.get();
	}//FIN METODO
	
	public StringProperty productoProperty() {
		return this.producto;
	}//FIN METODO
	
	public void setCantidad(Double cantidad) {
		this.cantidad.set(cantidad);
	}//FIN METODO
	
	public Double getCantidad() {
		return this.cantidad.get();
	}//FIN METODO
	
	public DoubleProperty cantidadProperty() {
		return this.cantidad;
	}//FIN METODO
	
	public void setUnidad(String unidad) {
		this.unidad.set(unidad);
	}//FIN METODO
	
	public String getUnidad() {
		return this.unidad.get();
	}//FIN METODO
	
	public StringProperty unidadProperty() {
		return this.unidad;
	}//FIN METODO
	
	public String toString() {
		return "" + this.getCantidad() + " " + this.getUnidad() + " " + this.getCodigo() + " " + this.getProducto() + "\n";
	}//FIN METODO

}//FIN CLASE
