package utilis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConn {
	private static DbConn instance;
	
	private String url = "jdbc:mysql://localhost:3306/sakila";
	private String username = "root";
	private String password = "prova";
	private Connection conn;
	
	private Statement stm;
	
	private DbConn()throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver"); //registro il mio driver
			
			this.conn = (Connection) DriverManager.getConnection(url, username, password); //apro la connessione
		} catch (ClassNotFoundException ex) {
			System.out.println("DB connesso : " + ex.getMessage()); //qualora è connesso leggo il mess nella stampa
		}
	}

	public Connection getConnection() {
		return conn; //se ho la connessione mi ritorna oggetto conn
	}

	public static DbConn getInstance() throws SQLException {
		if (instance == null) {
			instance = new DbConn();
		} else if (instance.getConnection().isClosed()) {
			instance = new DbConn();
		}

		return instance; //se non ho conn mi ritorna l'instance
	}

}
