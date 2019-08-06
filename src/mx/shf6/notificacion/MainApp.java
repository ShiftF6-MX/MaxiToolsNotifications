package mx.shf6.notificacion;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.mail.Session;

import javafx.application.Application;
import javafx.stage.Stage;
import mx.shf6.notificacion.model.Requisicion;
import mx.shf6.notificacion.model.dao.RequisicionDAO;
import mx.shf6.notificacion.utilities.ConnectionDB;
import mx.shf6.notificacion.utilities.LeerArchivo;
import mx.shf6.notificacion.utilities.Mail;
import mx.shf6.notificacion.utilities.SessionMail;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		
	}//FIN METODO

	public static void main(String[] args) {
		
		if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }//FIN IF
		
        Image image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\gran_\\eclipse-workspace\\ThreadTest\\F6_Icono.png");
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(image, "MaxiTools", popup);
        final SystemTray tray = SystemTray.getSystemTray();
        
        LeerArchivo.leerArchivo();
		ConnectionDB conexionBD = new ConnectionDB("demomaxicomercior5","localhost", "root", "Simons83Mx");
		Connection conexion = conexionBD.conectarMySQL();
        Requisicion requisicion = RequisicionDAO.readRequisicion(conexion, Integer.parseInt(args[0]));
        
      	SessionMail sessionMail = new SessionMail("ingenieria@gruposhift-f6.com.mx", "smtp.ionos.mx", "9+tvpP%+5zs6", "587");
      	Session session = sessionMail.iniciarSesionMail();
      	System.out.println(requisicion.getAsunto());
      	System.out.println(requisicion.getMensaje());
      	
      	Mail.correorequisicion(session, "joel.grande@gruposhift-f6.com.mx", requisicion.getAsunto(), requisicion.getMensaje());
        
        MenuItem exitItem = new MenuItem(requisicion.getNombreRemitente());
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }//FIN METODO
        });//FIN SENTENCIA
        
        popup.add(exitItem);
        trayIcon.setPopupMenu(popup);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
        
		launch(args);
	}//FIN METODO
	
}//FIN CLASE
