package packageMain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	private int AccountNumber;
	private String Name;
	private Double AccountBalance;
	public Account() {
		super();
	}
	public Account(int accountNumber, String name, Double accountBalance) {
		super();
		AccountNumber = accountNumber;
		Name = name;
		AccountBalance = accountBalance;
	}
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getAccountBalance() {
		return AccountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		AccountBalance = accountBalance;
	}
	
}
