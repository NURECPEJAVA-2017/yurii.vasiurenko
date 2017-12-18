package ua.nure.vasurenko.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactoryImpl implements ConnectionFactory {

	public Connection createConnection() throws DatabaseException {
		
		private String driver ;
		private String url ;
		private String user;
		private String password ;
		
		public ConnectionFactoryImpl(Properties properties){
			driver = properties.getProperty("connection.driver");
			url = properties.getProperty("connection.url");
			user = properties.getProperty("connection.user");
			password = properties.getProperty("connection.password");
		)
		}
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			throw new RuntimeException();
			
		}
		
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			
			throw new DatabaseException();
		}
		
	}

}