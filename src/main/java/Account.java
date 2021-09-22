import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public abstract class Account {
	private
	int accountNumber;
	int balance;
	Date dateCreated;
	
	public
	Account(){
		balance = 0;
		dateCreated = new Date();
	}
	Account(int ac){
		balance = 0;
		dateCreated = new Date();
		accountNumber = ac;
	}
	int getAccountNo(){
		return accountNumber;
	}
	void makeDeposit(int amount){
		balance += amount;
	}
	abstract boolean makeWithdrawal(int amount );
	
	int checkBalance(){
		System.out.println("Current Balance is: " + balance);
		return balance;
	}
	void printStatement(){
		System.out.println("---------Statement------------\n"
				+ "Account No: " + accountNumber + "\n"
				+ "Current Balance : " + balance + "\n");
	}
	boolean transferAmount(ArrayList<CheckingAccount> checking, ArrayList<SavingsAccount> saving ){
		Scanner reader = new Scanner(System.in);
		System.out.println("1. Transfer to a Checking Account\n2. Transfer to Savings account");
		int opt = reader.nextInt();
		reader.nextLine(); // to clear buffer
		
		if(opt == 1){
			System.out.println("Enter the reciever Account Number");
			int ra = reader.nextInt();
			reader.nextLine();

			boolean exists = false;
			for(CheckingAccount ca : checking){
				CheckingAccount temp = ca;
				if(temp.getAccountNo() == ra){
					System.out.print("Enter the amount to transfer: ");
					int amount = reader.nextInt();
					reader.nextLine();
					if(this.checkBalance() >= amount){
						temp.makeDeposit(amount);
						this.makeWithdrawal(amount);
					}
					exists = true;
				}
			}
			if(!exists){
				System.out.println("The reciever account does not exists");
			}
			
		}
		else if(opt == 2){
			System.out.println("Enter the reciever Account Number");
			int ra = reader.nextInt();
			reader.nextLine();

			boolean exists = false;
			for(SavingsAccount sa : saving){
				SavingsAccount temp = sa;
				if(temp.getAccountNo() == ra){
					System.out.print("Enter the amount to transfer: ");
					int amount = reader.nextInt();
					reader.nextLine();
					if(this.checkBalance() >= amount){
						temp.makeDeposit(amount);
						this.makeWithdrawal(amount);
						return true;
					}
					exists = true;
				}
			}
			if(!exists){
				System.out.println("The reciever account does not exists");
				return false;
			}
		}
		else{
			System.out.println("Invalid option");
		}
		
		return false;
	}

	abstract void displayAllDeductions();
}
