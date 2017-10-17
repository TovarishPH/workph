package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.caelum.jdbc.conexao.DataBase;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual", "root", "root");
		Connection con = DataBase.getConnection();
		Statement stmt = con.createStatement();
		boolean resultado = stmt.execute("insert into Produto (nome, descricao) values ('notebook', 'notebook i5')", stmt.RETURN_GENERATED_KEYS);
		System.out.println(resultado);
		
		ResultSet rs = stmt.getGeneratedKeys();
		
		while (rs.next()) {
			String id = rs.getString(1);
			System.out.println("ID: " + id + " gerado");
		}
		
		rs.close();
		stmt.close();
		con.close();
	}
}
