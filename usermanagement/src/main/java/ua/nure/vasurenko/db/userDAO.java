package ua.nure.vasurenko.db;

import java.util.Collection;

public interface UserDAO  {
	
	User create ( User t) throws DatabaseException;
	
	void update ( User  t) throws DatabaseException;
	
	void  delete (User t) throws DatabaseException;
	
	Collection <User> findAll() throws DatabaseException;
	
	User find(Long id) throws DatabaseException;
	
	void setConnectionFactory(ConnectionFactory connectionFactory);


}
