package in.Insurance.Model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AccountRegistration {

	

	private String firstName;

	private String lastName;

	private LocalDate dob;

	private String gender;

	private Long ssn;

	private Long phoneNo;

	private String email;

}
