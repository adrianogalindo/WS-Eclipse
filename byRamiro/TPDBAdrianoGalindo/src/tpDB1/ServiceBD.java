package tpDB1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ServiceBD {
		
		// Nom du pilote JDBC et URL de la base de données
			 private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			 private final String DB_URL = "jdbc:mysql://localhost:3306/college";//changer la base donnee
		//  Identifiants de la base de données
			 private final String USER = "root";
			 private final String PASS = "root";  // ou PASS="";
			 
			 private Connection conn;
			 private Statement stmt;
			 private ResultSet rs;
			 
			 private void ConnectBD(){
				 try {
					 
					 // Enregister le pilote JDBC
					    Class.forName(JDBC_DRIVER);
				
					 // Ouvrir une connection
					    conn = DriverManager.getConnection(DB_URL,USER,PASS);
					    	    
					 // Création de la déclaration;
					    stmt = conn.createStatement();
				 }			
				 catch (Exception e) {
						// TODO Auto-generated catch block
					 System.out.println("Sans connection à la base de données.");
					 System.out.println("Avez vous oublié de démarrer le serveur de base de donées ?");
					 System.out.println();
					 e.printStackTrace();
				 }			    
			 }
			 
			 public ServiceBD(){
				 ConnectBD();			 
			 }
			 
			 public void close(){
				 try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	 		 
			 }
			 
			 public ArrayList< ArrayList<Object>> executeQuery(String sql) {
				 
				ArrayList< ArrayList<Object>> lignes = new ArrayList< ArrayList<Object>>(); 				
				
				try {
					rs = stmt.executeQuery(sql); 
					ResultSetMetaData meta = rs.getMetaData();
					int colCount = meta.getColumnCount();
					while (rs.next()){
						 ArrayList<Object> ligne= new ArrayList<Object>();
						 for (int col=1; col <= colCount; col++){
							 ligne.add(rs.getObject(col));							 
							 }
						 lignes.add(ligne);
						 }						 	
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 		
				 return lignes;				 
			 }
			 
			 public int executeUpdate(String sql) throws RuntimeException{
				 int result;
				 try {
					result = stmt.executeUpdate(sql);
				} catch (SQLException e) {
					result =-1;
					throw new RuntimeException();
				}
				return result; 
			 }
			 
}



