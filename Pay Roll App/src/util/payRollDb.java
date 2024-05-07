package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import model.PayPojo;

public class payRollDb {
	

public static Connection getConnection() throws ClassNotFoundException, SQLException {
	
	
        Class.forName("com.mysql.cj.jdbc.Driver");
       	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/PayrollApp", "root", "root");
       	return connection;
     
	}
	
	public static boolean readLogin(PayPojo p) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
	
		String query = "select username,pasword from userDataList where username =? and pasword = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setString(1, p.getUserName());
		prepareStatement.setString(2, p.getPassword());
		
		//System.out.println("--------"+pojo.getUserName());
        ResultSet rows = prepareStatement.executeQuery();
        ResultSetMetaData metaData = (ResultSetMetaData) rows.getMetaData();
        int columnCount = metaData.getColumnCount();
        
        while(rows.next()) {
          
        	for (int i = 1; i <= columnCount; i += 1) {
               return true;
            }
            }
            System.out.println();
        
	
        return false;
}
}
