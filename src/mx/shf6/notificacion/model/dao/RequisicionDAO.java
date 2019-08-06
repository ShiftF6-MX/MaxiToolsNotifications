package mx.shf6.notificacion.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mx.shf6.notificacion.model.Requisicion;

public class RequisicionDAO {

	public static Requisicion readRequisicion(Connection conexion, Integer sysPK) {
		String consultaRead = "SELECT docf_documento.Sys_PK AS SysPK, user1.Username AS NombreRemitente, user1.Notes AS CorreoRemitente, docf_documento.IUsuario AS RemitenteFK, user2.Username AS NombreDestinatario, user2.Notes AS CorreoDestinatario, docf_documento.IDestinatario AS DestinatarioFK, docf_documento.Asunto AS Asunto, docf_documento.Notas AS Mensaje FROM docf_documento INNER JOIN tuser user1 ON docf_documento.IUsuario = user1.Sys_PK INNER JOIN tuser user2 ON docf_documento.IDestinatario = user2.Sys_PK WHERE docf_documento.Sys_PK = " + sysPK;
		Requisicion requisicion = new Requisicion();
		try {
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(consultaRead);
			while (resultados.next()) {
				requisicion.setSysPK(resultados.getInt(1));
				requisicion.setNombreRemitente(resultados.getString(2));
				requisicion.setCorreoRemitente(resultados.getString(3));
				requisicion.setRemitenteFK(resultados.getInt(resultados.getInt(4)));
				requisicion.setNombreDestinatario(resultados.getString(5));
				requisicion.setCorreoDestinatario(resultados.getString(6));
				requisicion.setDestinatarioFK(resultados.getInt(7));
				requisicion.setAsunto(resultados.getString(8));
				requisicion.setMensaje(resultados.getString(9));
			}//FIN WHILE
		} catch (SQLException sqle) {
			//Notificacion.dialogoException(sqle);
			return requisicion;
		}//FIN TRY CATCH
		return requisicion;
	}//FIN METODO
	
}//FIN METODO
