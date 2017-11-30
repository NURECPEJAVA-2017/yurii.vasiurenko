package ua.nure.vasurenko;

import org.junit.Test;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	@Test
	public void testFullName() {
		User user = new User();
		user.setFirstName("Yurii");
		user.setLastName("Vasurenko");
		String fullName = user.getFullName();
		assertEquals("Yurii Vasurenko", fullName); 
			

	}

}
