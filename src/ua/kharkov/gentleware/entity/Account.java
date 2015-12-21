package ua.kharkov.gentleware.entity;

public class Account {
	private int id;
	private int clientId;
	private double balance;
	private String nameOfBank;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getClientId() {
		return clientId;
	}
	
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getNameOfBank() {
		return nameOfBank;
	}
	
	public void setNameOfBank(String nameOfBank) {
		this.nameOfBank = nameOfBank;
	}
	
	public Account() {
		super();
	}
	
	public Account(int id, int clientId, double balance, String nameOfBank) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.balance = balance;
		this.nameOfBank = nameOfBank;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", clientId=" + clientId + ", balance="
				+ balance + ", nameOfBank=" + nameOfBank + "]";
	}
	
}
