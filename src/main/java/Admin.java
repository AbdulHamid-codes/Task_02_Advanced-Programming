import java.util.ArrayList;
import java.util.Scanner;

//
public class Admin extends Account{
	
	String userName;
	String password;
	
	void setUserName(String u){
		userName = u;
	}
	String getUserName(){
		return userName;
	}
	void setPassword(String p){
		password = p;
	}
	String getPassword(){
		return password;
	}
	boolean openAccount(ArrayList<Customer> customer, ArrayList<CheckingAccount> checking, ArrayList<SavingsAccount> saving ){
		Scanner read = new Scanner(System.in);
		System.out.println("Enter 1 to open Checking account\nEnter 2 to open Savings acccount");
		int opt = read.nextInt();
		read.nextLine();  // to clear buffer
		
		if(opt == 1){
			System.out.print("Enter the customers CNIC No: ");
			String nic = read.nextLine();
			
			boolean exists = false;
			for(Customer c : customer){
				Customer temp = c;
				if(temp.getCNIC().equals(nic)){
					exists = true;
				}
			}
			if(!exists){
				CheckingAccount temp = new CheckingAccount();
				checking.add(temp);
				
				Customer newCust = new Customer();
				
				System.out.print("Enter Customer name: ");
				newCust.setName(read.nextLine());
				System.out.print("Enter Customer Phone No: ");
				newCust.setPhone(read.nextInt());
				read.nextLine();  // to clean buffer
				System.out.print("Enter customer address: ");
				newCust.setAddress(read.nextLine());
				newCust.setCNIC(nic);
				newCust.setAccountNo(temp.getAccountNo());
				
				customer.add(newCust);
				System.out.println("Successfully created Account No: " + newCust.getAccountNo());
				return true;
				
			}
			else{
				System.out.println("Sorry--- The customer already has a checking account");
				return false;
			}
		}
		else if(opt == 2){
			System.out.print("Enter the customers CNIC No: ");
			String nic = read.nextLine();
			
			boolean exists = false;
			for(Customer c : customer){
				Customer temp = c;
				if(temp.getCNIC().equals(nic)){
					exists = true;
				}
			}
			if(!exists){
				SavingsAccount temp = new SavingsAccount();
				saving.add(temp);
				
				Customer newCust = new Customer();
				
				System.out.print("Enter Customer name: ");
				newCust.setName(read.nextLine());
				System.out.print("Enter Customer Phone No: ");
				newCust.setPhone(read.nextInt());
				read.nextLine();  // to clean buffer
				System.out.print("Enter customer address: ");
				newCust.setAddress(read.nextLine());
				newCust.setCNIC(nic);
				newCust.setAccountNo(temp.getAccountNo());
				customer.add(newCust);
				System.out.println("Successfully created Account No: " + newCust.getAccountNo());
				return true;
				
			}
			else{
				System.out.println("Sorry--- The customer already has a savings account");
				return false;
			}
		}
		else{
			System.out.println("Invalid option selected");
		}
		return false;
	}
	boolean closeAccount(ArrayList<Customer> customer, ArrayList<CheckingAccount> checking, ArrayList<SavingsAccount> saving){
		Scanner read = new Scanner(System.in);
		System.out.println("Enter 1 to Close a checking account\nEnter 2 to Close a savings account");
		int opt = read.nextInt();
		read.nextLine();
		System.out.print("Enter the account No: ");
		int account = read.nextInt();
		if(opt == 1){
			boolean exists = false;
			for(CheckingAccount ca : checking){
				CheckingAccount temp = ca;
				if(temp.getAccountNo() == account){
					checking.remove(temp);
					exists = true;
				}
			}
			if(exists){
				for(Customer c : customer){
					Customer temp = c;
					if(temp.getAccountNo() == account){
						customer.remove(temp);
						return true;
					}
				}
			}
		}
		else if(opt ==2){
			boolean exists = false;
			for(SavingsAccount sa : saving){
				SavingsAccount temp = sa;
				if(temp.getAccountNo() == account){
					saving.remove(temp);
					exists = true;
				}
			}
			if(exists){
				for(Customer c : customer){
					Customer temp = c;
					if(temp.getAccountNo() == account){
						customer.remove(temp);
						return true;
					}
				}
			}
		}
		else{
			System.out.println("Invalid Option");
		}
		return false;
		
	}
	void loginAccount(){
		
	}
	boolean setInterestRate(){
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter the interest rate to set for savings account");
		double interest = reader.nextInt();
		if(interest < 0) {
			System.out.println("Interet rate cannot be negative");
			return false;
		}
		SavingsAccount.setInterestRate(interest);
		return true;
	}
	boolean displayAccountDetails(){
		System.out.println("Back: ABC bank\n"
				+ "Total Checking Accounts: " + CheckingAccount.getTotal()
				+ "\nTotal Saving Accounts: " + SavingsAccount.getTotal());
		return true;
		}
	boolean displayAccountDeductions(){
		System.out.println("Back: ABC bank\n"
				+ "Total Checking Accounts: " + CheckingAccount.getTotal()
				+ "\nTotal Saving Accounts: " + SavingsAccount.getTotal());
		System.out.println("Tax deductions for Checking Accounts is dependent on total balance (5% above Rs.600000)\n"
				+ "Zakkat deduction for Savings Accounts is 2.5% if balance exceeds Rs.20000");
		return true;
	}
	@Override
	boolean makeWithdrawal(int amount) {
		return true;
	}
	@Override
	boolean displayAllDeductions(){
		return true;
	}
	
}
