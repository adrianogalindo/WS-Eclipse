package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDBServer {
	private static ConnDBServer INSTANCE;
	private Connection con;
	private String url = "jdbc:mysql://localhost:3306/db1";
	private String username = "root";
	private String password = "root";

	private ConnDBServer() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//
			this.con = DriverManager.getConnection(url, username, password);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public Connection getCon() {
        return con;
    }
    
	public static Connection getConnection() {
		return INSTANCE.con;
	}
    
    public static ConnDBServer getINSTANCE() throws SQLException {
        if (INSTANCE == null) {
        	INSTANCE = new ConnDBServer();
        } else if (INSTANCE.getCon().isClosed()) {
        	INSTANCE = new ConnDBServer();
        }
        return INSTANCE;
    }
	
	

}
