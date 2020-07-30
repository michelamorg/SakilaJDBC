package testDb;

import java.sql.Connection;
import java.sql.SQLException;

import utilis.DbConn;

public class DbTest {

	public static void main(String[] args) {
		try {
			Connection conn=DbConn.getInstance().getConnection(); //se è connesso il DbConn
			System.out.println("Connesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
