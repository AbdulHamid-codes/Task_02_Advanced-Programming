
public class Customer {
	private
	String name;
	String address;
	int phoneNumber;
	int accountNumber;
	String CNIC;
	
	public
	void setName(String n){
		name = n;
	}
	String getName(){
		return name;
	}
	void setAccountNo(int a){
		accountNumber = a;
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
	void setAddress(String ad){
		address=ad;
	}
	String getAddress(){
		return address;
	}
	void setCNIC(String cn){
		CNIC = cn;
	}
	String getCNIC(){
		return CNIC;
	}
}
