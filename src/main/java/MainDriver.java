
import java.util.Scanner;
import java.util.ArrayList;

public class MainDriver {
	
	static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("----Welcome to ABC Bank----");
		System.out.print("Please set your Admin username: ");
		String admin = reader.nextLine();
		System.out.print("Please set your Admin password: ");
		String pass = reader.nextLine();
		Admin admin1 = new Admin();
		admin1.setUserName(admin);
		admin1.setPassword(pass);
		
		// Array lists to store the customers and both type of accounts
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();
		ArrayList<SavingsAccount> savingAccounts = new ArrayList<SavingsAccount>();
		
		while(true){
			System.out.println("------------------------------");
			System.out.println("Please choose your option");
			System.out.println("1. Login as Admin\n"
					+ "2. Login as customer\n3. Exit");
			int option=reader.nextInt();
			String cleanBuf=reader.nextLine();
			
			if(option==1){
				System.out.print("Please enter your user name: ");
				String userName=reader.nextLine();
				System.out.print("Please enter your password: ");
				String pas=reader.nextLine();
				// If admin username is valid
				if(userName.equals(admin1.getUserName()) && pas.equals(admin1.getPassword())){
					
					System.out.println("------------------------------");
					System.out.println("Please choose your option\n"
							+ "1. Open new Account\n"
							+ "2. Close Account\n"
							+ "3. Log in to some account\n"
							+ "4. Specify the Interest Rate, applicable to all Saving Accounts\n"
							+ "5. Display all account details, including the bank owner details\n"
							+ "6. Display all accounts deductions along with account details\n");
					int opt = reader.nextInt();
					reader.nextLine(); // to clear buffer
					switch(opt){
					case 1:
						admin1.openAccount(customers, checkingAccounts, savingAccounts);
						break;
					case 2:
						admin1.closeAccount(customers, checkingAccounts, savingAccounts);
						break;
					case 3:
						
						break;
					case 4:
						admin1.setInterestRate();
						break;
					case 5:
						admin1.displayAccountDetails();
						break;
					case 6:
						admin1.displayAccountDeductions();
						break;
					default:
						System.out.println("Please Choose a valid option");	
					}
				}
				else{
					System.out.println("---Sorry Invalid Username or Password");
				}
			}
			else if(option == 2){
				System.out.print("Please enter your account number: ");
				int account=reader.nextInt();
				cleanBuf=reader.nextLine();
				boolean found = false;
				// Search the provided account No
				for(Customer c: customers){
					Customer c1 = c;
					if(c1.getAccountNo() == account){
						found = true;
					}
				}
				// if the customer exists
				if(found){
					System.out.println("------------------------------");
					System.out.println("Please choose your option\n"
							+ "1. Log in to Checking Account\n"
							+ "2. Log in to Savings Account");
					int opt = reader.nextInt();
					cleanBuf = reader.nextLine();
					boolean check = false;
					
					if(opt == 1){
						// Search the provided account No
						for(CheckingAccount ca: checkingAccounts){
							CheckingAccount ca1 = ca;
							if(ca1.getAccountNo() == account){   // Account do exists
								System.out.println("------------------------------");
								System.out.println("Please choose your option\n"
										+"1. Make Deposit\n"									
										+ "2. Make Withdrawal\n"
										+ "3. Check Balance\n"
										+ "4. Print Statement\n"
										+ "5. Transfer Ammount\n"
										+ "6. Display all Deductions\n");
								int choice = reader.nextInt();
								reader.nextLine(); // to clear buffer
								switch(choice){
								case 1:
									System.out.print("Enter the amount to deposit: ");
									ca1.makeDeposit(reader.nextInt());
									break;
								case 2:
									System.out.print("Enter the amount to withdraw: ");
									ca1.makeWithdrawal(reader.nextInt());
									break;
								case 3:
									ca1.checkBalance();
									break;
								case 4:
									ca1.printStatement();
									break;
								case 5:
									ca1.transferAmount(checkingAccounts, savingAccounts);
									break;
								case 6:
									ca1.displayAllDeductions();
									break;
								default:
										System.out.println("Please choose a valid option");
								}
							
								check = true;
								break;
							}
						}
					}
					else if(opt == 2){
						// Search the provided account No
						for(SavingsAccount sa: savingAccounts){
							SavingsAccount sa1 = sa;
							if(sa1.getAccountNo() == account){   // Account do exists
								System.out.println("------------------------------");
								System.out.println("Please choose your option\n"
										+"1. Make Deposit\n"									
										+ "2. Make Withdrawal\n"
										+ "3. Check Balance\n"
										+ "4. Print Statement\n"
										+ "5. Transfer Ammount\n"
										+ "6. Calculate zakkat\n"
										+ "7. Display all Deductions\n"
										+ "8. Calculate interest rate");
								int choice = reader.nextInt();
								reader.nextLine();
								switch(choice){
								case 1:
									System.out.print("Enter the amount to deposit: ");
									sa1.makeDeposit(reader.nextInt());
									break;
								case 2:
									System.out.print("Enter the amount to withdraw: ");
									sa1.makeWithdrawal(reader.nextInt());
									break;
								case 3:
									sa1.checkBalance();
									break;
								case 4:
									sa1.printStatement();
									break;
								case 5:
									sa1.transferAmount(checkingAccounts, savingAccounts);
									break;
								case 6:
									sa1.calculateZakat();
									break;
								case 7:
									sa1.displayAllDeductions();
									break;
								case 8:
									sa1.calculatelnterest();
								default:
										System.out.println("Please choose a valid option");
								}
								check = true;
								break;
							}
						}
					}
					else{
						System.out.println("Please choose a valid option");
					}
					if(!check){
						System.out.println("You donot have a savings Account\n"
								+ "You may choose Checking account");
					}
				}
				else{
					System.out.println("Account does not exits..Please enter valid accountNo");
				}
			}
			else if(option == 3){
				break;
			}
			else{
				System.out.println("Please choose a valid option");
			}
		}
	}
}
