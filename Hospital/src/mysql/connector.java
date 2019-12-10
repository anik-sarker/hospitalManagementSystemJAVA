package mysql;
import java.sql.*;

public class connector {
	
	 String userName = "root";
	 String passWord= "";
	 String serverAdress= "jdbc:mysql://localhost:3306/hospital";
	 
	 Connection connection;
	 Statement mystatement;
	 
	public Statement connector(){

			
				try {
					
					connection = DriverManager.getConnection(serverAdress, userName, passWord);
					mystatement = connection.createStatement();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
			
			
			return mystatement;
	 }
	
	
 
}
