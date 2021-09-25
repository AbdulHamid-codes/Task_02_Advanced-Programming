
public class Customer {
	private
	String name;
	String address;
	int phoneNumber;
	int accountNumber;
	String CNIC;
	
	public
	boolean setName(String n){
		if(n.length() < 5) {
			System.out.println("Name too short");
			return false;
		}
		name = n;
		return true;
	}
	String getName(){
		return name;
	}
	boolean setAccountNo(int a){
		if(a <= 0) {
			System.out.println("Account No cannot be 0 or negative");
			return false;
		}
		accountNumber = a;
		return true;
	}
	int getAccountNo(){
		return accountNumber;
	}
	void setPhone(int p){
		phoneNumber = p;
	}
	int getPhone(){
		return phoneNumber;
	}
	boolean setAddress(String ad){
		if(ad.length() < 6) {
			System.out.println("Address too short");
			return false;
		}
		address=ad;
		return true;
	}
	String getAddress(){
		return address;
	}
	boolean setCNIC(String cn){
		if(cn.length() != 13) {
			System.out.println("CNIC length is not in 13 digit format");
			return false;
		}
		CNIC = cn;
		return true;
	}
	String getCNIC(){
		return CNIC;
	}
}
