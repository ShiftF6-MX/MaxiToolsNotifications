package mx.shf6.notificacion.model;

import java.util.ArrayList;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Requisicion {

	//PROPIEDADES
	private ObjectProperty<Integer> sysPK;
	private StringProperty nombreRemitente;
	private StringProperty correoRemitente;
	private ObjectProperty<Integer> remitenteFK;
	private StringProperty nombreDestinatario;
	private StringProperty correoDestinatario;
	private ObjectProperty<Integer> destinatarioFK;
	private StringProperty asunto;
	private StringProperty mensaje;
	private ArrayList<DetalleRequisicion> detalleRequisicion;
	
	//CONSTRUCTORES
	public Requisicion() {
		this(0, "", "", 0, "", "", 0, "", "", new ArrayList<DetalleRequisicion>());
	}//FIN CONSTRUCTOR
	
	public Requisicion(Integer sysPK, String nombreRemitente, String correoRemitente, Integer remitenteFK, String nombreDestinatario, String correoDestinatario, Integer destinatarioFK, String asunto, String mensaje, ArrayList<DetalleRequisicion> detalleRequisicion) {
		this.sysPK = new SimpleObjectProperty<Integer>(sysPK);
		this.nombreRemitente = new SimpleStringProperty(nombreRemitente);
		this.correoRemitente = new SimpleStringProperty(correoRemitente);
		this.remitenteFK = new SimpleObjectProperty<Integer>(remitenteFK);
		this.nombreDestinatario = new SimpleStringProperty(nombreDestinatario);
		this.correoDestinatario = new SimpleStringProperty(correoDestinatario);
		this.destinatarioFK = new SimpleObjectProperty<Integer>(destinatarioFK);
		this.asunto = new SimpleStringProperty(asunto);
		this.mensaje = new SimpleStringProperty(mensaje);
		this.detalleRequisicion = detalleRequisicion;
	}//FIN METODO
	
	public void setSysPK(Integer sysPK) {
		this.sysPK.set(sysPK);
	}//FIN METODO
	
	public Integer getSysPK() {
		return this.sysPK.get();
	}//FIN METOO
	
	public ObjectProperty<Integer> sysPKProperty() {
		return this.sysPK;
	}//FIN METODO
	
	public void setNombreRemitente(String nombreRemitente) {
		this.nombreRemitente.set(nombreRemitente);
	}//FIN METODO
	
	public String getNombreRemitente() {
		return this.nombreRemitente.get();
	}//FIN METODO
	
	public StringProperty nombreRemitenteProperty() {
		return this.nombreRemitente;
	}//FIN METODO
	
	public void setCorreoRemitente(String correoRemitente) {
		this.correoRemitente.set(correoRemitente);
	}//FIN METODO
	
	public String getCorreoRemitente() {
		return this.correoRemitente.get();
	}//FIN METODO
	
	public StringProperty correoRemitenteProperty() {
		return this.correoRemitente;
	}//FIN METODO
	
	public void setRemitenteFK(Integer remitenteFK) {
		this.remitenteFK.set(remitenteFK);
	}//FIN METODO
	
	public Integer getRemitenteFK() {
		return this.remitenteFK.get();
	}//FIN METODO}
	
	public ObjectProperty<Integer> remitenteFKProperty() {
		return this.remitenteFK;
	}//FIN METODO
	
	public void setNombreDestinatario(String nombreDestinatario) {
		this.nombreDestinatario.set(nombreDestinatario);
	}//FIN METODO
	
	public String getNombreDestinatario() {
		return this.nombreDestinatario.get();
	}//FIN METODO
	
	public StringProperty nombreDestinatarioProperty() {
		return this.nombreDestinatario;
	}//FIN METODO
	
	public void setCorreoDestinatario(String correoDestinatario) {
		this.correoDestinatario.set(correoDestinatario);
	}//FIN METODO
	
	public String getCorreoDestinatario() {
		return this.correoDestinatario.get();
	}//FIN METODO
	
	public StringProperty correoDestinatarioProperty() {
		return this.correoDestinatario;
	}//FIN METODO
	
	public void setDestinatarioFK(Integer remitenteFK) {
		this.destinatarioFK.set(remitenteFK);
	}//FIN METODO
	
	public Integer getDestinatarioFK() {
		return this.destinatarioFK.get();
	}//FIN METODO}
	
	public ObjectProperty<Integer> destinatarioFKProperty() {
		return this.destinatarioFK;
	}//FIN METODO
	
	public void setAsunto(String asunto) {
		this.asunto.set(asunto);
	}//FIN METODO
	
	public String getAsunto() {
		return this.asunto.get();
	}//FIN METODO
	
	public StringProperty asuntoProperty() {
		return this.asunto;
	}//FIN METODO
	
	public void setMensaje(String mensaje) {
		this.mensaje.set(mensaje);
	}//FIN METODO
	
	public String getMensaje() {
		return this.mensaje.get();
	}//FIN METODO
	
	public StringProperty mensaje() {
		return this.mensaje;
	}//FIN METODO
	
	public void setDetalleVenta(ArrayList<DetalleRequisicion> detalleVenta) {
		this.detalleRequisicion = detalleVenta;
	}//FIN METODO
	
	public ArrayList<DetalleRequisicion> getDetalleRequisicion() {
		return this.detalleRequisicion;
	}//FIN METODO
		
}//FIN CLASE
