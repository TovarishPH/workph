package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.caelum.jdbc.conexao.DataBase;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DataBase.getConnection();
		Statement stmt = con.createStatement();
		boolean resultado = stmt.execute("delete from Produto where id>3");
		System.out.println(resultado);
		int count = stmt.getUpdateCount();
		System.out.println("Foram deletadas " + count + " linas");
		
		stmt.close();
		con.close();
	}
}
