package ua.nure.vasurenko.db;

import java.util.Collection;
import java.util.Date;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.junit.Test;

import ua.nure.vasurenko.User;
import ua.nure.vasurenko.db.ConnectionFactory;
import ua.nure.vasurenko.db.ConnectionFactoryImpl;
import ua.nure.vasurenko.db.DatabaseException;
import ua.nure.vasurenko.db.HsqldbUserDao;

public class HsqldbUserDAOtest extends DatabaseTestCase {
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;
	
	
	protected void setUp() throws Exception {
		dao = new HsqldbUserDao(connectionFactory);
//		super.setUp();
	}
	
	
	@Test
	public void testCreate(){
		User user = new User();
		user.setFirstName("Yurii");
		user.setLastName("Vasurenko");
		user.setDateOfBirth(new Date());
		assertNull(user.getId());
		try {
			user = dao.create(user);
		} catch (DatabaseException e) {
			
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertNotNull(user);
		assertNotNull(user.getId());
		
	}
	
	@Test
	public void testFindAll(){
		try {
			Collection<User> collection = dao.findAll();
			assertNotNull(collection);
			assertEquals(2, collection.size());
		} catch (DatabaseException e) {
			
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	

	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connectionFactory = new ConnectionFactoryImpl();
		return new DatabaseConnection(connectionFactory.createConnection());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new XmlDataSet(
				getClass()
				.getClassLoader()
				.getResourceAsStream("usersDataSet.xml"));
		return null;
	}

}