package ua.kharkov.gentleware.test;

import java.util.List;

import ua.kharkov.gentleware.db.ClientServiceImpl;
import ua.kharkov.gentleware.entity.Account;
import ua.kharkov.gentleware.entity.Client;

public class Test {
	public static void main(String[] args) {
		ClientServiceImpl cs = new ClientServiceImpl();
		List<Account> accounts= cs.getAllAccount();
		
		Client client = cs.getClientWithMaxBalance(accounts);
		System.out.println("Client with max balance==> " + client.getName()); 
		
		System.out.println("Total client balance==> " + cs.getClientBalance(client, accounts));
		
	}

}
