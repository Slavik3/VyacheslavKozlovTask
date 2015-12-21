package ua.kharkov.gentleware.entity;

public class Client {
	private int id;
	private String name;
	private String surname;
	private String email;
	private int inn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getInn() {
		return inn;
	}
	public void setInn(int inn) {
		this.inn = inn;
	}
	
	public Client() {
		super();
	}
	
	public Client(int id, String name, String surname, String email, int inn) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.inn = inn;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", email=" + email + ", inn=" + inn + "]";
	}
	
}
