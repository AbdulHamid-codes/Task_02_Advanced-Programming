 import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {

	SavingsAccount savings;
	ArrayList<CheckingAccount> ca;
	ArrayList<SavingsAccount> sa;
	
	@Before
	public void executeBefore() {
		savings= new SavingsAccount();
		ca = new ArrayList<CheckingAccount>();
		sa = new ArrayList<SavingsAccount>();
	}
	
	@Test
	public void makeDepositTestPositve() {
		assertEquals(true, savings.makeDeposit(500));
	}
	@Test
	public void makeDepositTestNegative() {
		assertEquals(false, savings.makeDeposit(-5));
	}

	@Test
	public void printStatementTest() {
		assertEquals(true, savings.printStatement());
	}
	
	@Test
	public void transferAmountTestPositve() {
		assertEquals(false, savings.transferAmount(ca, sa)); 
	}
	@Test
	public void transferAmountTestNegative() {
		assertEquals(false, savings.transferAmount(ca, sa));
	}
	@Test
	public void makeWithdrawalTestPositve() {
		assertEquals(true, savings.makeWithdrawal(0)); 
	}
	@Test
	public void makeWithdrawalTestNegative() {
		assertEquals(false, savings.makeWithdrawal(70000));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void calculateZakatTest() {
		assertEquals(0, savings.calculateZakat(), 0); 
	}
	

}
