package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnUtils {
	public static Connection getPostgreSQLConnection() throws ClassNotFoundException, SQLException {
	    String hostName = "tuffi.db.elephantsql.com";
	    String dbName = "ewqmbzkb";
	    String userName = "ewqmbzkb";
	    String password = "HS8Ksj1fLi7UZEe0IDqhmfcZLgpxhQq-";

		return getPostgreSQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getPostgreSQLConnection(String hostName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
	    
	    String connectionURL = "jdbc:postgresql://"+ hostName +":5432/" + dbName;
	
	    Connection conn = DriverManager.getConnection(connectionURL, userName, password);
	    return conn;
	}
}
