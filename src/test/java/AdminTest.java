import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AdminTest {

	Admin admin;
	ArrayList<CheckingAccount> checking;
	ArrayList<SavingsAccount> saving;
	ArrayList<Customer> customer;
	
	@Before
	public void createRequirements() {
		admin = new Admin();
		checking = new ArrayList<CheckingAccount>();
		saving = new ArrayList<SavingsAccount>();
	    customer = new ArrayList<Customer>();
		
		
	}
	
	@Test
	public void createAccountTestPositive() {
		assertEquals(true,admin.openAccount(customer, checking, saving));    
	}
	
	@Test
	public void createAccountTestNegative() {
		assertEquals(true,admin.openAccount(customer, checking, saving));
	}
	
	@Test
	public void closeAccountTestPositive() {
		assertEquals(false,admin.closeAccount(customer, checking, saving));   // Delete a valid account
	}
	
	@Test
	public void closeAccountTestNegative() {
		assertEquals(false,admin.closeAccount(customer, checking, saving));  // Delete a non existant account
	}
	
	@Test
	public void displayAccountDetails() {
		assertEquals(true,admin.displayAccountDetails());     
	}
	@Test
	public void displayAccountDeductions() {
		assertEquals(true,admin.displayAccountDeductions());    
	}
	
	@Test
	public void setInterstRateTestPositive() {
		assertEquals(true,admin.setInterestRate());     // input a positive value for interest rate
	}
	@Test
	public void setInterstRateTestNegative() {
		assertEquals(false,admin.setInterestRate());    // input a negative value for interest rate
	}

}
