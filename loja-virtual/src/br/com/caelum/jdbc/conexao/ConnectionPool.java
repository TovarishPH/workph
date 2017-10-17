package br.com.caelum.jdbc.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class ConnectionPool {
	
	private DataSource dataSource;

	public ConnectionPool() {
		MysqlConnectionPoolDataSource pool = new MysqlConnectionPoolDataSource();
		pool.setUrl("jdbc:mysql://localhost/loja_virtual");
		pool.setUser("root");
		pool.setPassword("root");
		this.dataSource = pool;
	}
	
	public Connection getConnection() throws SQLException{
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual", "root", "root");
		Connection con = dataSource.getConnection();

		return con;
	}
}
