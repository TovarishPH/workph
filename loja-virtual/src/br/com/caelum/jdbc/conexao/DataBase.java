package br.com.caelum.jdbc.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

	public static Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual", "root", "root");

		return con;
	}
}
