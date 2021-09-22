
public class SavingsAccount extends Account {
	private
	static double interestRate;
	static int uniqueNo;
	
	public
	SavingsAccount(){
		super(++uniqueNo);
	}
	
	static void setInterestRate(double i){
		interestRate = i;
	}
	double calculatelnterest(){	
		System.out.println("Current interset rate is: " + interestRate);
		return interestRate ;
	}
	double calculateZakat(){
		if(balance >= 20000){
			return ((balance*2.5)/100);
		}
		return 0;
	}
	static int getTotal(){
		return uniqueNo;
	}
	@Override
	boolean makeWithdrawal(int amount){
		if(balance >= amount){
			balance -= amount;
			return true;
		}
		return false;
	}
	@Override
	void displayAllDeductions(){
		System.out.println("Zakkat amount is: " + ((balance*2.5)/100));
	}

}
