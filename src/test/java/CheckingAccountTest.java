import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class CheckingAccountTest {
	CheckingAccount checking;
	ArrayList<CheckingAccount> ca;
	ArrayList<SavingsAccount> sa;
	
	@Before
	public void executeBefore() {
		checking= new CheckingAccount();
		ca = new ArrayList<CheckingAccount>();
		sa = new ArrayList<SavingsAccount>();
	}
	
	@Test
	public void makeDepositTestPositve() {
		assertEquals(true, checking.makeDeposit(500));
	}
	@Test
	public void makeDepositTestNegative() {
		assertEquals(false, checking.makeDeposit(-5));
	}

	@Test
	public void printStatementTest() {
		assertEquals(true, checking.printStatement());
	}
	
	@Test
	public void transferAmountTestPositve() {
		assertEquals(false, checking.transferAmount(ca, sa)); 
	}
	@Test
	public void transferAmountTestNegative() {
		assertEquals(false, checking.transferAmount(ca, sa));
	}
	@Test
	public void makeWithdrawalTestPositve() {
		assertEquals(true, checking.makeWithdrawal(1200)); 
	}
	@Test
	public void makeWithdrawalTestNegative() {
		assertEquals(false, checking.makeWithdrawal(70000));
	}
}
