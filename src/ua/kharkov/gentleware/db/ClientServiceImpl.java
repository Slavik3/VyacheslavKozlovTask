package ua.kharkov.gentleware.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ua.kharkov.gentleware.entity.Account;
import ua.kharkov.gentleware.entity.Client;

public class ClientServiceImpl implements ClientService {

	private static String SQL_SELECT_ALL_FROM_ACCOUNT = "SELECT * FROM account;";
	private static String SQL_SELECT_CLIENT_BY_ID = "SELECT * FROM client where id = ?;";

	private static String SQL_SELECT_CLIENT_SURNAME_WITH_MIN_BALANCE = "SELECT surname FROM client, "
			+ "(SELECT client_id AS cid, SUM(balance) AS sum_balance FROM account GROUP BY client_id DESC LIMIT 1) AS T WHERE client.id = cid;";
	private static String SQL_SELECT_CLIENT_SURNAME_WITH_MAX_BALANCE = "SELECT surname FROM client, "
			+ "(SELECT client_id AS cid, SUM(balance) AS sum_balance FROM account GROUP BY client_id LIMIT 1) AS T WHERE client.id = cid;";

	public List<Account> getAllAccount() {
		Connection con = null;
		List<Account> list = new ArrayList<Account>();
		try {
			con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(SQL_SELECT_ALL_FROM_ACCOUNT);
			while (result.next()) {
				Account account = extractAccount(result);
				list.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return list;
	}

	/**
	 * Get cumulative balance by client accounts
	 */
	@Override
	public double getClientBalance(Client client, List<Account> accounts) {
		int clientId = client.getId();
		int balance = 0;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getClientId() == clientId) {
				balance += accounts.get(i).getBalance();
			}
		}
		return balance;
	}

	/**
	 * Get client with max balance in a particular bank
	 */
	@Override
	public Client getClientWithMaxBalance(List<Account> accounts) {
		double maxBalance = 0;
		double balance;
		int clientId;
		int IdClientWithMaxBalance = 0;
		for (int i = 0; i < accounts.size(); i++) {
			balance = accounts.get(i).getBalance();
			clientId = accounts.get(i).getClientId();
			if (maxBalance < balance) {
				maxBalance = balance;
				IdClientWithMaxBalance = clientId;
			}
		}
		Client client = getClientById(IdClientWithMaxBalance);
		return client;
	}

	public Client getClientById(int id) {
		Client client = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement(SQL_SELECT_CLIENT_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				client = extractClient(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return client;
	}

	private Account extractAccount(ResultSet rs) throws SQLException {
		Account account = new Account();
		account.setId(rs.getInt("id"));
		account.setClientId(rs.getInt("client_id"));
		account.setBalance(rs.getInt("balance"));
		account.setNameOfBank(rs.getString("name_of_bank"));
		return account;
	}

	private Client extractClient(ResultSet rs) throws SQLException {
		Client client = new Client();
		client.setId(rs.getInt("id"));
		client.setName(rs.getString("name"));
		client.setSurname(rs.getString("surname"));
		client.setEmail(rs.getString("email"));
		client.setInn(rs.getInt("inn"));
		return client;
	}

	private void close(Connection connection) {
		try {
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
