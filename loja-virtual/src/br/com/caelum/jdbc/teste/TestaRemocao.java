package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual", "root", "root");
		Statement stmt = con.createStatement();
		boolean resultado = stmt.execute("delete from Produto where id>3");
		System.out.println(resultado);
		int count = stmt.getUpdateCount();
		System.out.println("Foram deletadas " + count + " linas");
		
		stmt.close();
		con.close();
	}
}
