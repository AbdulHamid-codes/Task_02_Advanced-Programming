
import java.util.Date;
public class CheckingAccount extends Account {
	private
	int transactionsThisMonth;
	Date lastTransactionDate;
	static int uniqueNo = 0;
	
	public
	CheckingAccount(){
		super(++uniqueNo);
	}
	
	int getTransactions(){
		return transactionsThisMonth;
	}
	int transactionFee(){
		
		return 0;
	}
	static int getTotal(){
		return uniqueNo;
	}
	@Override
	boolean makeWithdrawal(int amount){
		if(balance+5000 >= amount){
			balance -= amount;
			return true;
		}
		else{
			System.out.println("Not enough balance to perform the transaction");
			return false;
		}
	}
	@Override
	boolean displayAllDeductions(){
		System.out.println("Tax amount according 5% is: " + balance * 0.05);
		return true;
	}
}
