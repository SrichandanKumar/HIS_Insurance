package in.Insurance.Model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class AccountRegistration {

	private Integer registrationNo;

	private String firstName;

	private String lastName;

	private LocalDate dob;

	private String gender;

	private Long ssn;

	private Long phoneNo;

	private String email;

}
