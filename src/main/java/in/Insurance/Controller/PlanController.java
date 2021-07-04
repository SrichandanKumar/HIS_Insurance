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

import in.Insurance.Model.Plan;
import in.Insurance.Service.PlanService;

@RestController
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private PlanService service;
	
	
	@PostMapping("/savePlan")
	public ResponseEntity<String> savePlan( @RequestBody Plan plan){
		ResponseEntity<String> response=null;
		
		Integer savedPlanId = service.savePlan(plan);
		
		String body="Your Plan is created successfully with id "+" "+savedPlanId;
		
		response=new ResponseEntity<String>(body, HttpStatus.CREATED);
		
		return response;
	}
	
	
	@GetMapping("/viewAllPlan")
	public List<Plan> vewAllPlan(){
		Integer pageNo=2;
		Integer pageSize=2;
		
		List<Plan> allPlans = service.getAllPlans(pageNo,pageSize);
		
		return allPlans;
	}
	
	@GetMapping("/deletePlan/{id}")
	public String deletePlan(@PathVariable("id") Integer id) {
		System.out.println(id);
		 String deletePlan = service.deletePlan(id);
		return deletePlan;
	}
	
}
