package in.Insurance.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="AccountRegistration")
public class AccountRegistrationEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Registration_No")
	private Integer registrationNo;
	
	@Column(name="First_Name")
	private String firstName;
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="DOB")
	private LocalDate dob;
	@Column(name="Gender")
	private String gender;
	
	@Column(name="SSN")
	private Long ssn;
	
	@Column(name="Phone_No")
	private Long phoneNo;
	
	@Column(name="Email")
	private String email;
	
	@CreationTimestamp
	@Column(name="Created_Date",updatable=false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name="Update_Date",insertable=false)
	private LocalDate updateDate;
	
	
}
