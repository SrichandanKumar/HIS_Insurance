package in.Insurance.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import in.Insurance.Entity.AccountRegistrationEntity;
import in.Insurance.Exception.NoDataFoundException;
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

	
	@Override
	public List<AccountRegistration> getAllRegistration() {
		
		List<AccountRegistrationEntity> registrationEntityList = registrationRepo.findAll();
		
		if(registrationEntityList.isEmpty()) {
			 throw new NoDataFoundException("No Registrations record found");
		}
		
	return	registrationEntityList.stream().map(regi->{
		AccountRegistration registration=new AccountRegistration();
			BeanUtils.copyProperties(regi, registration);
			
			return registration;
		}).collect(Collectors.toList());
		
	}
	
	@Override
	public AccountRegistration getRegistrationById(Integer id) {
		
		Optional<AccountRegistrationEntity> findById = registrationRepo.findById(id);
		
		if(findById.isPresent()) {
			  AccountRegistrationEntity accountRegistrationEntity = findById.get();
			  AccountRegistration ar=new AccountRegistration();
			  BeanUtils.copyProperties(accountRegistrationEntity, ar);
			  
			  return ar;
		}
		
	 throw new NoDataFoundException("No Data found on given "+id);
	}
	
	@Override
	public Integer updateAccountRegistration(AccountRegistration registration) {
		
		AccountRegistrationEntity entity=new AccountRegistrationEntity();
		
		if(registration.getRegistrationNo()!=null) {
			
			boolean existsById = registrationRepo.existsById(registration.getRegistrationNo());
			
			if(existsById== true) {
				BeanUtils.copyProperties(registration, entity);
				AccountRegistrationEntity updatedEntity = registrationRepo.save(entity);
			return updatedEntity.getRegistrationNo();
			}
			else {
				throw new NoDataFoundException("Invalid Registration no");
			}
			
		}
		
		
		throw new  NullPointerException();
	}
	
	
}
