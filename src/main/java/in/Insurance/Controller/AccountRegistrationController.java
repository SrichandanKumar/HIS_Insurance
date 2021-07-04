package in.Insurance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.Insurance.Model.AccountRegistration;
import in.Insurance.Service.AccountRegistrationService;

@RestController

@RequestMapping("/register")
public class AccountRegistrationController {

	@Autowired
	private AccountRegistrationService service;
	
	
	@PostMapping("/saveAccountRegistration")
	public ResponseEntity<String> saveAccountRegistration(@RequestBody AccountRegistration registration){
		ResponseEntity< String> response=null;
		
		Integer registerNo = service.saveAccountRegistration(registration);
		
		String body="AccountRegistration Saved Successfully and RegisterNumber is "+" "+registerNo;
		
		response=new ResponseEntity<String>(body, HttpStatus.CREATED);
		
		return response;
	}
	
	
}
