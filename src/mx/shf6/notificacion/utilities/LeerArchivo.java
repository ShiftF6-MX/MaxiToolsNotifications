package mx.shf6.notificacion.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivo {
    
    //VARIABLES
    private static List<String> content;
    public static String nameDB;
    public static String hostDB;
    public static String userDB;
    public static String passwordDB;
    public static String claveEquipo;
    public static String correoAutorizarCompras;
    public static String correoRequisiciones;
    public static String contrasenaRequisiciones;
    
    public static void leerArchivo(){
        try {
        	//PUT CONNECTIONDATA FILE ON C:\MaxicomercioTools\ PATH
            LeerArchivo.content = Files.readAllLines(Paths.get("C:\\MaxicomercioTools\\ConnectionData.dat"));
            LeerArchivo.nameDB = content.get(2);
            LeerArchivo.hostDB = content.get(4);
            LeerArchivo.userDB = content.get(6);
            LeerArchivo.passwordDB = content.get(8);
            LeerArchivo.correoAutorizarCompras = content.get(10);
            LeerArchivo.correoRequisiciones = content.get(12);
            LeerArchivo.contrasenaRequisiciones = content.get(14);
        } catch (IOException | IndexOutOfBoundsException ioe) {
            System.out.println(ioe.toString());
        }//END TRY/CATCH
    }//END METHOD
    
    public static ArrayList<String> leerArchivoUI(int dimension){
        ArrayList<String> listaMenus = new ArrayList<String>();
        try {
        	//PUT USERINTERFACEDATA FILE ON C:\MaxicomercioTools\ PATH
            LeerArchivo.content = Files.readAllLines(Paths.get("C:\\MaxicomercioTools\\UserInterfaceData.dat"));
            for (int i = 1; i <= dimension ; i ++) {
            	listaMenus.add(content.get(i*2));
            }//FIN FOR
        } catch (IOException | IndexOutOfBoundsException ioe) {
        	System.out.println(ioe.toString());
        }//END TRY/CATCH
        return listaMenus;
    }//END METHOD
    
    public static String leerPathServidor(){
        try {
        	//PUT USERINTERFACEDATA FILE ON C:\MaxicomercioTools\ PATH
            LeerArchivo.content = Files.readAllLines(Paths.get("C:\\MaxicomercioTools\\ServerData.dat"));
            return content.get(2);
        } catch (IOException | IndexOutOfBoundsException ioe) {
        	System.out.println(ioe.toString());
        }//END TRY/CATCH
        return "";
    }//END METHOD
    
    public static String leerPathCFDIs(){
        try {
        	//PUT USERINTERFACEDATA FILE ON C:\MaxicomercioTools\ PATH
            LeerArchivo.content = Files.readAllLines(Paths.get("C:\\MaxicomercioTools\\ServerData.dat"));
            return content.get(4);
        } catch (IOException | IndexOutOfBoundsException ioe) {
        	System.out.println(ioe.toString());
        }//END TRY/CATCH
        return "";
    }//END METHOD
    
    public static boolean cargarArchivo(File archivo, String destino) {
    	if (archivo.renameTo(new File(destino)))
    		return true;
    	else
    		return false;
    }//FIN METODO
    
    /**
     *
     * @return
     */
    public static String aCadena() {
        String datos = "Base de Datos: " + nameDB + "\n"
                + "Host: " + hostDB + "\n"
                + "Usuario: " + userDB + "\n"
                + "Contraseña: " + passwordDB;
        return datos;
    }//END METHOD    
    
}//END CLASS
