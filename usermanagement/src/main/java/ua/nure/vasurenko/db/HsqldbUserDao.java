package ua.nure.vasurenko.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import ua.nure.vasurenko.User;

public class HsqldbUserDao implements UserDAO {

	private ConnectionFactory connectionFactory;

	public HsqldbUserDao(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
		// TODO Auto-generated constructor stub
	}
	public HsqldbUserDao(){
		
	}
	

	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
		
	}



	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}



	@Override
	public User create(User user) throws DatabaseException {
		try {
			User resultUser = new User(user);
			Connection connection = connectionFactory.createConnection();

			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO users(firstname,lastname,dateofbirth)VALUES (?,?,?");

			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setDate(3, new Date(user.getDateOfBirth().getTime()));
			int n = statement.executeUpdate();
			if (n != 1) {
				throw new DatabaseException("Number of the inserted rows;" + n);
			}
			CallableStatement callableStatement = connection.prepareCall("call IDENTITY()");
			ResultSet id = callableStatement.executeQuery();
			if (id.next()) {
				resultUser.setId(new Long(id.getLong(1)));

			}
			id.close();
			callableStatement.close();
			statement.close();
			connection.close();
			return resultUser;

		} catch (SQLException e) {
			throw new DatabaseException(e);

		}
	}

	@Override
	public void update(User t) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User t) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<User> findAll() throws DatabaseException {
		Collection<User>result = new LinkedList<User>();
		try{
		Connection connection = connectionFactory.createConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT )
			
				ResultSet resultSet = statement.executeQuery("SELECT id,firstname,lastname,dateofbirth FROM users");
		while (resultSet.next()){
			User user = new User ();
			user.setId(new Long(resultSet.getLong(1)));
			user.setFirstName(resultSet.getString(2));
			user.setLastName(resultSet.getString(3));
			user.setDateOfBirth(resultSet.getDate(4));
			result.add(user);
			
		}
		resultSet.close();
		statement.close();
		connection.close();
		
		}catch (SQLException e){
			throw new DatabaseException(e);
		}
		
		return result;
	}

	@Override
	public User find(Long id) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
