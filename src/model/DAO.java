package model;

import java.sql.Connection;
import java.sql.DriverManager;
//Inicio do código
public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://10.26.49.177:3306/agenda";//acresentar o nome da agenda
	private String user = "root";
	private String password = "123@senac";
	
	/**
	 * Método responsável por abrir uma conexão com o banco de dados.
	 * @return
	 */
	public Connection conectar() {
		// Criar um objeto.
		Connection con = null;
		//Traramento de exeções
		try {
			// Lógica principal para abrir a comexão.
			//Uso do driver
			Class.forName(driver);
			//Obter os parâmetros da conexão (Informações do Servidor).
			con = DriverManager.getConnection(url, user, password); //Conectar.
			//Retornar a Conexão ("Abrir a porta da geladeira").
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
}// Fim do código
