package in.Insurance.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Insurance.Entity.AccountEntity;
import in.Insurance.Exception.AccountNotCreatedException;
import in.Insurance.Exception.NoDataFoundException;
import in.Insurance.Model.Account;
import in.Insurance.Model.CredentialCheck;
import in.Insurance.Repository.AccountRepository;
import in.Insurance.Service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accRepo;

	@Override
	public Integer saveAccount(Account acc) {

		
			acc.setStatus("NotActive");
		

		AccountEntity entity = new AccountEntity();
		BeanUtils.copyProperties(acc, entity);

		AccountEntity savedAcc = accRepo.save(entity);

		if (savedAcc.getId() != null) {
			return savedAcc.getId();
		}

		throw new AccountNotCreatedException("Account Failed to create");
	}

	@Override
	public List<Account> getAllAccountByRole(String role) {

		List<AccountEntity> acclist = accRepo.findByRole(role);

		if (acclist.isEmpty()) {
			throw new NoDataFoundException("Record not Found for given role");
		}

		return acclist.stream().map(entity -> {
			Account account = new Account();
			BeanUtils.copyProperties(entity, account);
			return account;
		}).collect(Collectors.toList());

	}
	
	@Override
	public String CheckCredential(CredentialCheck credential) {
		
	String 	email=credential.getEmail();
	String password=credential.getPassword();
		
		AccountEntity savedEntity = accRepo.findByEmailAndPassword(email, password);
		if(savedEntity!=null) {
			if(savedEntity.getEmail().equals(email) && savedEntity.getPassword().equals(password)) {
				
				if(savedEntity.getStatus().equalsIgnoreCase("Active")) {
				
					return "Valid credential";
				}
				
				return "Your status is not Active";
			}
			return "In-Valid credential";
		}
		
		return "In-Valid credential";
	}
	
	//checking email
	
	@Override
	public String checkEmail(String email) {
		    AccountEntity accountEntity = accRepo.findByEmail(email);
		    
		    if(accountEntity !=null && accountEntity.getStatus().equals("Active")) {
		    	
		    	return "Valid Email";
		    }
		    
		return "In-Valid Email";
	}
	
}
