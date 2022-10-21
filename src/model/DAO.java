package model;

import java.sql.Connection;
import java.sql.DriverManager;
//Inicio do c�digo
public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://10.26.49.177:3306/agenda";//acresentar o nome da agenda
	private String user = "root";
	private String password = "123@senac";
	
	/**
	 * M�todo respons�vel por abrir uma conex�o com o banco de dados.
	 * @return
	 */
	public Connection conectar() {
		// Criar um objeto.
		Connection con = null;
		//Traramento de exe��es
		try {
			// L�gica principal para abrir a comex�o.
			//Uso do driver
			Class.forName(driver);
			//Obter os par�metros da conex�o (Informa��es do Servidor).
			con = DriverManager.getConnection(url, user, password); //Conectar.
			//Retornar a Conex�o ("Abrir a porta da geladeira").
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
}// Fim do c�digo
