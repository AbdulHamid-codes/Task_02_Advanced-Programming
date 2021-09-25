import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	Customer customer;
	@Before
	public void executeBefore() {
		customer = new Customer();
	}

	@Test
	public void setCNICtestPositve() {
		assertEquals(true, customer.setCNIC("1234567123453"));
	}
	@Test
	public void setCNICtestNegative() {
		assertEquals(false, customer.setCNIC("12345671234"));
	}
	@Test
	public void setAddressTestPositve() {
		assertEquals(true, customer.setAddress("Street 4, Sector H-11, Islamabad"));
	}
	@Test
	public void setAddressTestNegative() {
		assertEquals(false, customer.setAddress("stre"));
	}
	@Test
	public void setAccountNoTestPositve() {
		assertEquals(true, customer.setAccountNo(12));
	}
	@Test
	public void setAccountNoTestNegative() {
		assertEquals(false, customer.setAccountNo(-1));
	}
	@Test
	public void setNameTestPositve() {
		assertEquals(true, customer.setName("Abdul Hamid"));
	}
	@Test
	public void setNameTestNegative() {
		assertEquals(false, customer.setName("abc"));
	}
}
