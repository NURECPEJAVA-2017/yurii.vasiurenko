package ua.nure.vasurenko;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	
	private static final int DAY_OF_BIRTH1 = 03;
	private static final int MONTH_OF_BIRTH1 = Calendar.DECEMBER;
	private static final int YEAR_OF_BIRTH = 1999;
	private static final int CURRENT_YEAR = 2017;
	
	
	private static final int ETALONE_AGE1 = CURRENT_YEAR-YEAR_OF_BIRTH;
	private User user;
	private Date dateOfBirth;
	
	
	
	private static final int DAY_OF_BIRTH2 = 03;
	private static final int MONTH_OF_BIRTH2 = Calendar.AUGUST;
	
	
	private static final int DAY_OF_BIRTH3 = 07;
	private static final int MONTH_OF_BIRTH3 = Calendar.DECEMBER;
	
	private static final int ETALONE_AGE2 = CURRENT_YEAR-YEAR_OF_BIRTH-1;
	private static final int DAY_OF_BIRTH4 = 17;
	private static final int MONTH_OF_BIRTH4 = Calendar.DECEMBER;
	
	private static final int CURRENT_YEAR1 = 2018;
	private static final int ETALONE_AGE3 = CURRENT_YEAR1-YEAR_OF_BIRTH-1;
	private static final int DAY_OF_BIRTH5 = 03;
	private static final int MONTH_OF_BIRTH5 = Calendar.FEBRUARY;
	
	
	
	protected void setUp() throws Exception{
		super.setUp();
		user = new User();		
	}
	
	@Test
	public void testFullName(){
		
		user.setFirstName("Dasha");
		user.setLastName("Mezentseva");
		String fullName = user.getFullName();
		assertEquals("Dasha Mezentseva", fullName);
	}
	
	
	@Test
	public void testGetAge1(){
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH1,DAY_OF_BIRTH1); 
		user.setDateOfBirth(calendar.getTime());
		//dateOfBirth = calendar.getTime();
		assertEquals(ETALONE_AGE1, user.getAge());

		
	}
	
	@Test
	public void testGetAge2(){
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH2,DAY_OF_BIRTH2);
		user.setDateOfBirth(calendar.getTime());
		//dateOfBirth = calendar.getTime();
		
		assertEquals(ETALONE_AGE1, user.getAge());

		
	}
	@Test
	public void testGetAge3(){
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH3,DAY_OF_BIRTH3);
		user.setDateOfBirth(calendar.getTime());
		//dateOfBirth = calendar.getTime();
		assertEquals(ETALONE_AGE1, user.getAge());

		
	}
	@Test
	public void testGetAge4(){
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH4,DAY_OF_BIRTH4);
		user.setDateOfBirth(calendar.getTime());
		//dateOfBirth = calendar.getTime();
		assertEquals(ETALONE_AGE2, user.getAge());

		
	}
	@Test
	public void testGetAge5(){
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH5,DAY_OF_BIRTH5);
		user.setDateOfBirth(calendar.getTime());
		//dateOfBirth = calendar.getTime();
		
		assertEquals(ETALONE_AGE3, user.getAge());

		
	}
	
}