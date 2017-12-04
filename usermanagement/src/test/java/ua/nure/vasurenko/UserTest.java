package ua.nure.vasurenko;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	private static final int ETALONE_AGE = 2018 - 1984;
	private static final String ETALONE_AGE1 = null;
	private User user;
	private Date dateOfBirth;
	
	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
		Calendar calendar = Calendar.getInstance();
		calendar.set(1984, Calendar.MAY,26);
		dateOfBirth = calendar.getTime();
	}

	public void testGetFullName(){
		user.setFirstName("Yurii");
		user.setLastName("Vasurenko");
		assertEquals("Vasurenko Yurii",user.getFullName());
	}
		
		public void testGetAge() {
			
			user.setDateOfBirth(dateOfBirth);
			assertEquals(ETALONE_AGE1,user.getId());
		}
	
	@Test
	public void testFullName() {
		User user = new User();
		user.setFirstName("Yurii");
		user.setLastName("Vasurenko");
		String fullName = user.getFullName();
		assertEquals("Yurii Vasurenko", fullName); 
			

	}

	public static int getEtaloneAge() {
		return ETALONE_AGE;
	}

}
