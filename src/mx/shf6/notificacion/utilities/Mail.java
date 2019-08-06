package mx.shf6.notificacion.utilities;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	//METODO PARA VALIDAR SI UN COORREO REGISTRADO ES VALIDO
	public static boolean correorequisicion(Session session, String correoElectronico, String asunto, String mensajeRequisicion){
		String mensaje = "<p><img src=\"http://app.canadevihidalgo.com.mx/assets/img/encabezado.png\"</img></p>"
				+ "<font face=\"Roboto\" size=\"2\">Buen día,</font></strong>"
				+ "<p><font face=\"Roboto\" size=\"2\">" + mensajeRequisicion + "</font></p>"
				+ "<p><img src=\"http://app.canadevihidalgo.com.mx/assets/img/pie.png\"</img></p>";
		boolean validacion = enviarCorreo(session, correoElectronico, asunto, mensaje);
		if (validacion==true) {
			return true;
		}else {
			return false;
		}
	}//FIN METODO
	
	
	//METODO PARA ENVIAR CORREOS ELECTRONICOS
	public static boolean enviarCorreo(Session session, String destinatario, String asunto, String mensaje) {		
	    MimeMessage message = new MimeMessage(session);
	    Transport transport=null;
	    try {
	        message.setFrom(new InternetAddress("ingenieria@gruposhift-f6.com.mx"));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
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