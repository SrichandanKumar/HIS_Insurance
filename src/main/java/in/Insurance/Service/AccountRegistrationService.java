package in.Insurance.Service;

import java.util.List;

import in.Insurance.Model.AccountRegistration;

public interface AccountRegistrationService {

	public Integer saveAccountRegistration(AccountRegistration registration);

	
	public List<AccountRegistration> getAllRegistration();
	
	public AccountRegistration getRegistrationById(Integer id);

	
	public Integer updateAccountRegistration(AccountRegistration registration);
		

	
}
