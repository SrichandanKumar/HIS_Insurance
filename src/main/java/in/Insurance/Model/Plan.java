package in.Insurance.Model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Plan {

	private String planName;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private String activeSwitch;
	
}
