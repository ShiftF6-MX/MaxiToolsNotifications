package mx.shf6.notificacion.utilities;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;

public class SessionMail {
	
	//VARIABLES
	private Session session;
	private final String remitente;
	private final String servidorSMTP;
	private final String contrasenaMail;
	private final String puertoSMTP;
	
	public SessionMail(String rMail, String sMail, String cMail, String pMail){
		this.remitente= rMail;
		this.servidorSMTP= sMail;
		this.contrasenaMail= cMail;
		this.puertoSMTP= pMail;
		
	}//FIN METODO
	
	
	//METODO PARA INICIAR SESION PÁRA ENVIAR CORREO ELECTRONICO
	public Session iniciarSesionMail() { 
	    Properties properties = System.getProperties();
	    properties.put("mail.smtp.host", servidorSMTP);  //El servidor SMTP del servidor de correo
	    properties.put("mail.smtp.user", remitente);  //Direccion de correo emisor (nomcuenta@gmail.com)
	    properties.put("mail.smtp.clave", contrasenaMail);    //La clave de la cuenta
	    properties.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    properties.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    properties.put("mail.smtp.port", puertoSMTP); //El puerto SMTP seguro del servido 1&1
	    session = Session.getDefaultInstance(properties);
	    
	    return session;
	}//FIN METODO
		
	
	//METODO PARA TERMINAR TRANSPORT
	 public void terminarConexion(Session session){
		 try {			
			session.getTransport().close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	 }//FIN METODO
	 
}//FIN CLASE