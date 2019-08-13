package pack1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Emp {
	public int id;
	public String name;
	public int age;
	public String address;
	public float salary;

	public Emp() {
		// TODO Auto-generated constructor stub
	}

	public Emp(int id, String name, int age, String address, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
	}

}

public class QueryEmp {

	public static List<Emp> EmpList = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//
			Class.forName("com.mysql.jdbc.Driver");
			//
			String url = "jdbc:mysql://localhost:3306/EMP";
			Connection con = DriverManager.getConnection(url, "root", "root");
			//
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);
			System.out.println();
			//
			Statement stmt;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY");

			while (rs.next()) {
				Emp anEmp = new Emp();
				anEmp.id = rs.getInt("id");
				anEmp.name = rs.getString("name");
				anEmp.age = rs.getInt("age");
				anEmp.address = rs.getString("address");
				anEmp.salary = rs.getFloat("salary");
				EmpList.add(anEmp);

			}
			rs.close();
			stmt.close();
			con.close();
			for (Emp data : EmpList) {
				System.out.println("ID = " + data.id);
				System.out.println("NAME = " + data.name);
				System.out.println("AGE = " + data.age);
				System.out.println("ADDRESS = " + data.address);
				System.out.println("SALARY = " + data.salary);
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end main
}// end class
