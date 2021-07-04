package in.Insurance.Service;

import java.util.List;

import in.Insurance.Model.Plan;

public interface PlanService {

	
	public Integer savePlan(Plan plan);
	
	
	public List<Plan> getAllPlans(Integer pageNo,Integer pageSize);
	
	public String deletePlan(Integer id);
}
