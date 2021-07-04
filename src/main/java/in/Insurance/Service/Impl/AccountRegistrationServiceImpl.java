package in.Insurance.Service.Impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Insurance.Entity.AccountRegistrationEntity;
import in.Insurance.Exception.NoResourceCreatedException;
import in.Insurance.Model.AccountRegistration;
import in.Insurance.Repository.AccountRegistrationRepository;
import in.Insurance.Service.AccountRegistrationService;

@Service
public class AccountRegistrationServiceImpl implements AccountRegistrationService {

	@Autowired
	private AccountRegistrationRepository registrationRepo;
	
	
	@Override
	public Integer saveAccountRegistration(AccountRegistration registration) {
		
		AccountRegistrationEntity entity=new AccountRegistrationEntity();
		
		BeanUtils.copyProperties(registration, entity);
		AccountRegistrationEntity savedEntity = registrationRepo.save(entity);
		
		if(savedEntity !=null) {
			return savedEntity.getRegistrationNo();
		}
		
		
	throw new NoResourceCreatedException("Failed to Register");
	}

}
