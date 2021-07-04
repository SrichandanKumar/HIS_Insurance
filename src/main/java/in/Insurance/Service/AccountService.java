package in.Insurance.Service;

import java.util.List;

import in.Insurance.Model.Account;
import in.Insurance.Model.CredentialCheck;

public interface AccountService {
	
	public Integer  saveAccount(Account acc);

	public List<Account> getAllAccountByRole(String role);
	
	
	public String CheckCredential(CredentialCheck credential);
	
	
	public String checkEmail(String email);
	
}
