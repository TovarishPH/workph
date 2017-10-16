package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual", "root", "root");
		Statement stmt = con.createStatement();
		boolean resultado = stmt.execute("insert into Produto (nome, descricao) values ('notebook', 'notebook i5')", stmt.RETURN_GENERATED_KEYS);
		System.out.println(resultado);
		
		ResultSet rs = stmt.getGeneratedKeys();
		
		while (rs.next()) {
			String id = rs.getString("Produto.id");
			System.out.println("ID: " + id + " gerado");
		}
		
		stmt.close();
		con.close();
	}
}
