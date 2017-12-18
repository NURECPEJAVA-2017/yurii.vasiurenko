package ua.nure.vasurenko.db;

import java.sql.SQLException;

public class DatabaseException extends Exception {

	public DatabaseException(String string) {
		super (string);
	}

	public DatabaseException(SQLException e) {
		
		super (e);
		 
		// TODO Auto-generated constructor stub
	}

	public DatabaseException() {
		super ();
	
	}

}
