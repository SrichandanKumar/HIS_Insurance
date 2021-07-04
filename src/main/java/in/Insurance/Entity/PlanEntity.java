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
@Table(name="Plan")
public class PlanEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Plan_Id")
	private Integer planId;
	
	@Column(name="Plan_Name")
	private String planName;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Start_Date")
	private LocalDate startDate;
	
	@Column(name="End_Date")
	private LocalDate endDate;
	
	@Column(name="Active_Switch")
	private String activeSwitch;
	

	@Column(name="Created_Date",updatable=false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name="Update_Date",insertable=false)
	private LocalDate updateDate;

	
	
}
