package ua.kharkov.gentleware.db;

import java.util.List;

import ua.kharkov.gentleware.entity.Account;
import ua.kharkov.gentleware.entity.Client;

public interface ClientService {
	 double getClientBalance(Client client, List<Account> accounts);
     Client getClientWithMaxBalance(List<Account> accounts);
}
