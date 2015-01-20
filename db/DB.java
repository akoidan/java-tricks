package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DB {
	
	
	
	public static void main (String[] arg) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
			
			
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root",null);
		java.sql.Statement statement =connection.createStatement();
		
//		INSERT INTO table_name (column1,column2,column3,...)
//VALUES (value1,value2,value3,...);
		
//		statement.execute("INSERT INTO JustAtable (id, age, name)VALUES (0, 23, 'kota') ; ");
		ResultSet resultset= statement.executeQuery("Select * from JustAtable");
		 while (resultset.next()) {
          System.out.println("age : "+ resultset.getInt("age"));
			 System.out.println(" name: "+resultset.getString("name"));			 
      }
		 connection.close();	
	}
}
