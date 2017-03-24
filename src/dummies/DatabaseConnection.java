package dummies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitnami_orangehrm","root","manager");
		Statement stmt=c.createStatement();
		ResultSet rs=stmt.executeQuery("select emp_firstname from hs_hr_employee");
		while(rs.next()){
			System.out.println(rs.getString(1)/*+" "+rs.getString(2)+" "+rs.getString(3)*/);
		}
		c.close();
	}
}
