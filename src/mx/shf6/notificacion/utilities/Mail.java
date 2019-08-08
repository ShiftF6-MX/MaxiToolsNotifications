package mx.shf6.notificacion.utilities;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import mx.shf6.notificacion.model.DetalleRequisicion;
import mx.shf6.notificacion.model.Requisicion;

public class Mail {
	
	//METODO PARA VALIDAR SI UN COORREO REGISTRADO ES VALIDO
	public static boolean correorequisicion(Session session, Requisicion requisicion, String correoAutorizarCompra){
		String detalleTextoRequisicion = "";
		for (DetalleRequisicion detalleRequisicion : requisicion.getDetalleRequisicion())
			detalleTextoRequisicion += detalleRequisicion.toString() + "<br>";
				
		String mensaje = "<p><img src=\"http://maquinadosreyes.com.mx/wp-content/uploads/2019/08/encabezado.png\"</img></p>"
				+ "<font face=\"Roboto\" size=\"2\">Tienes una nueva requisición por aprobar,</font></strong>"
				+ "<p><font face=\"Roboto\" size=\"2\">" + requisicion.getMensaje() + "</font></p>"
				+ "<p><font face=\"Roboto\" size=\"2\">" + detalleTextoRequisicion + "</font></p>"
				+ "<p><font face=\"Roboto\" size=\"2\">" + "Atte. " + requisicion.getNombreRemitente() + "</font></p>"
				+ "<p><img src=\"http://maquinadosreyes.com.mx/wp-content/uploads/2019/08/pie.png\"</img></p>";
		boolean validacion = enviarCorreo(session, requisicion.getCorreoDestinatario(), requisicion.getAsunto(), mensaje, correoAutorizarCompra);
		if (validacion==true) {
			return true;
		}else {
			return false;
		}
	}//FIN METODO
	
	
	//METODO PARA ENVIAR CORREOS ELECTRONICOS
	public static boolean enviarCorreo(Session session, String destinatario, String asunto, String mensaje, String correoAutorizarCompra) {		
	    MimeMessage message = new MimeMessage(session);
	    Transport transport=null;
	    try {
	        message.setFrom(new InternetAddress("requisiciones@maquinadosreyes.com.mx", "Sistema ERP - Requisiciones"));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.addRecipients(Message.RecipientType.CC, correoAutorizarCompra); 
	        message.setSubject(asunto);
	        //message.setText(mensaje);
	        message.setContent(mensaje, "text/html");
	        try {
	        	transport = session.getTransport("smtp");
	        } catch (MessagingException e) {
				e.printStackTrace();
			}
	        transport.connect((String) session.getProperties().get("mail.smtp.host"), (String) session.getProperty("mail.smtp.user"), (String) session.getProperty("mail.smtp.clave"));
	        transport.sendMessage(message, message.getAllRecipients());	        
	        return true;//RETORNA UN TRUE SI EL CORREO PUDO SER ENVIADO
	    }
	    catch (Exception me) {
	        me.printStackTrace();   //Si se produce un error
	        return false; //RETORNA UN FALSE SI EL CORREO NO PUDO SER ENVIADO
	    }
	}//FIN METODO
	
}//FIN CLASE