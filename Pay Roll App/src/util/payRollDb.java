package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.PayPojo;

public class payRollDb {
public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
        Class.forName("com.mysql.cj.jdbc.Driver");
       	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/PayrollApp", "root", "root");
       	return connection;
     
	}
	
	public static void payRollData(PayPojo pp) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		//UserCredPayroll ucp = new UserCredPayroll();
		
		String query =" insert into userDataList values (?,?,?,?,?)";
		
		PreparedStatement prep = connection.prepareStatement(query);
		
		prep.setInt(1, 0);
		prep.setString(2,pp.getUserName());
		prep.setString(3,pp.getPassword());
		prep.setString(4,pp.getMailId());
		prep.setString(5,pp.getDepartment());
		
		
		int rows = prep.executeUpdate();
		System.out.println("Rows Affected : " + rows);
	}
	
}
