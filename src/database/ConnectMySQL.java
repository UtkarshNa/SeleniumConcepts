package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ConnectMySQL {
	
	@Test
	public void testDB() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.jdbc.Driver");  // Driver of MY SQL
		
		System.out.println("Driver Loaded " );
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","#Utkarsh95");
		
		System.out.println("Connected to My SQL DB " );
		
		Statement smt=con.createStatement();
		
		ResultSet rs=smt.executeQuery("select * from cus");
		
		while(rs.next()) {
			
			String name=rs.getString("name");
			
			System.out.println("Record is found "+ name );
			
            //String email=rs.getString("email");
			
			//System.out.println("Record is found "+ email );
		}
		con.close();
	}

}
