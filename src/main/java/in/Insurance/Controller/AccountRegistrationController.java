package in.Insurance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/getAllRegistration")
	public ResponseEntity<List<AccountRegistration>> getAllRegistration(){
		
		System.out.println("getAllRegistration");
		ResponseEntity<List<AccountRegistration>> response=null;
		 List<AccountRegistration> allRegistration = service.getAllRegistration();
		 System.out.println(allRegistration);
		 
		 
		 response= new ResponseEntity<List<AccountRegistration>>((List<AccountRegistration>) allRegistration, HttpStatus.OK);
		 
		return response; 
	}
	
	@GetMapping("/getRegistrationById/{id}")
	public ResponseEntity<AccountRegistration> getRegistrationById(@PathVariable("id")Integer id){
		
		ResponseEntity<AccountRegistration> response=null;
		AccountRegistration registrationById = service.getRegistrationById(id);
		
		response=new ResponseEntity<AccountRegistration>(registrationById, HttpStatus.OK);
		
		return response;
	}
	
	//update Account registration
	
	
	@PutMapping("/updateAccountRegistration")
	public ResponseEntity<String> updateAccountRegistration(@RequestBody AccountRegistration registration){
		ResponseEntity<String> response=null;
		
		Integer updateAccountNo = service.updateAccountRegistration(registration);
		String body="Your Account is successfully update with "+" "+"registration No."+updateAccountNo;
		
		response=new ResponseEntity<String>(body, HttpStatus.CREATED);
	
	return response;
	}
	
	
}
