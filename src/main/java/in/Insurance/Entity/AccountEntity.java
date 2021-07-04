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

@Data
@Entity
@Table(name="Account")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Account_id")
	private Integer id;
	
	@Column(name="First_Name")
	private String fname;
	
	@Column(name="Last_Name")
	private String lname;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Role")
	private String role;
	
	@CreationTimestamp
	@Column(name="Created_Date",updatable=false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name="Updated_Date",insertable=false)
	private LocalDate updatedDate;
}
