package in.Insurance.Model;

import lombok.Data;

@Data
public class Account {
	
    private Integer id;
	private String fname;
	private String lname;
	private String email;
	
	private String password;
	private String gender;
	
	private String status;
	
	private String role;

}
