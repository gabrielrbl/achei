package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		/*
	    String hostName = "remotemysql.com";
	    String dbName = "GYpj5oZ7C7";
	    String userName = "GYpj5oZ7C7";
	    String password = "sJDr13FhMR";
	    */
	     
	    // LOCAL
	    ///*
	    String hostName = "localhost";
	    String dbName = "achei";
	    String userName = "root";
	    String password = "root";
	    //*/
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    
	    String connectionURL = "jdbc:mysql://"+ hostName +":3306/" + dbName;
	
	    Connection conn = DriverManager.getConnection(connectionURL, userName, password);
	    return conn;
	}
}
