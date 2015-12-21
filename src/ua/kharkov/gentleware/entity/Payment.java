package ua.kharkov.gentleware.entity;

public class Payment {
	private int id;
	private int accountFromId;
	private int accountToId;
	private int amountOfPayment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountFromId() {
		return accountFromId;
	}
	public void setAccountFromId(int accountFromId) {
		this.accountFromId = accountFromId;
	}
	public int getAccountToId() {
		return accountToId;
	}
	public void setAccountToId(int accountToId) {
		this.accountToId = accountToId;
	}
	public int getAmountOfPayment() {
		return amountOfPayment;
	}
	public void setAmountOfPayment(int amountOfPayment) {
		this.amountOfPayment = amountOfPayment;
	}
	
	public Payment() {
		super();
	}
	
	public Payment(int id, int accountFromId, int accountToId,
			int amountOfPayment) {
		super();
		this.id = id;
		this.accountFromId = accountFromId;
		this.accountToId = accountToId;
		this.amountOfPayment = amountOfPayment;
	}
	
	@Override
	public String toString() {
		return "Payment [id=" + id + ", accountFromId=" + accountFromId
				+ ", accountToId=" + accountToId + ", amountOfPayment="
				+ amountOfPayment + "]";
	}
	
}
