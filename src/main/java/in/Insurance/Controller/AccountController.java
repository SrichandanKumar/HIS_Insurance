package in.Insurance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.Insurance.Entity.AccountEntity;
import in.Insurance.Model.Account;
import in.Insurance.Model.CredentialCheck;
import in.Insurance.Service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService service;

	@PostMapping("/saveAccount")
	public ResponseEntity<String> saveAccount(@RequestBody Account acc) {

		ResponseEntity<String> response = null;

		Integer saveAccNum = service.saveAccount(acc);

		String body = "Your Account Number is " + " " + saveAccNum;

		response = new ResponseEntity<String>(body, HttpStatus.CREATED);

		return response;
	}

	@GetMapping("/getAllAccountByRole/{role}")
	public List<Account> getAllAccountByRole(@PathVariable("role") String role) {

		List<Account> accList = service.getAllAccountByRole(role);

		accList.forEach(acc -> {
			System.out.println(acc);
		});

		return accList;
	}

	@PostMapping("/updateAccount")
	public ResponseEntity<String> updateAccount(@RequestBody Account acc) {

		ResponseEntity<String> response = null;

		Integer saveAccNum = service.saveAccount(acc);

		String body = "Your Account  " + " " + saveAccNum + " " + "Is updated successfully";

		response = new ResponseEntity<String>(body, HttpStatus.OK);

		return response;
	}

	@GetMapping("/checkCredential")
	public ResponseEntity<String> checkCredentials(@RequestBody CredentialCheck credential) {
		ResponseEntity<String> response = null;
		String checkCredential = service.CheckCredential(credential);

		response = new ResponseEntity<String>(checkCredential, HttpStatus.OK);

		return response;
	}

	@GetMapping("/checkEmail/{email}")
	public String checkEmail(@PathVariable("email") String email) {
		String msg = service.checkEmail(email);

		return msg;
	}

}