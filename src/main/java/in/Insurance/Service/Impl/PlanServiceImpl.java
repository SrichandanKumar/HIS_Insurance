package in.Insurance.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import in.Insurance.Entity.PlanEntity;
import in.Insurance.Exception.NoDataFoundException;
import in.Insurance.Exception.NoResourceCreatedException;
import in.Insurance.Model.Plan;
import in.Insurance.Repository.PlanRepository;
import in.Insurance.Service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepo;
	
	@Override
	public Integer savePlan(Plan plan) {
		
		plan.setActiveSwitch("y");
		PlanEntity entity=new PlanEntity();
		BeanUtils.copyProperties(plan, entity);
		
		PlanEntity savedEntity = planRepo.save(entity);
		
		if(savedEntity.getPlanId()!=null) {
			return savedEntity.getPlanId();
		}
		
		throw new NoResourceCreatedException("Plan failed to save");
	}
	
	
	@Override
	public List<Plan> getAllPlans(Integer pageNo,Integer pageSize) {
		
		PageRequest pageable = PageRequest.of(pageNo-1, pageSize);
		
		Page<PlanEntity> page = planRepo.findAll(pageable);
		List<PlanEntity> planList = page.getContent();
		
		/*List<PlanEntity> planList = planRepo.findAll();*/
		
		if(planList.isEmpty()) {
			throw new NoDataFoundException("No Plan Found");
		}
	return	planList.stream().map(planed->{
			Plan plan=new Plan();
			BeanUtils.copyProperties(planed, plan);
			return plan;
		}).collect(Collectors.toList());
		
	}
	
	@Override
	public String deletePlan(Integer id) {
		
		Optional<PlanEntity> entity = planRepo.findById(id);
		
		if(entity.isPresent()) {
			PlanEntity planEntity = entity.get();
		  if(planEntity.getActiveSwitch()!=null && planEntity.getActiveSwitch().equalsIgnoreCase("y") ) {
			  String status="N";
			  System.out.println("Y block called"+id+status);
			   planRepo.updateStatusById(id, status);
			   
			  return "Delete successfully";
			    /* if(updateStatus!=null) {
			     if(updateStatus.getActiveSwitch().equals("y")) {
			    	return "Activate successfully";
			    }
			    else {
			    	return "Not Activate";
			    }*/
			   //  }
		  }
		  else  if(planEntity.getActiveSwitch()!=null && planEntity.getActiveSwitch().equalsIgnoreCase("N") ) {
			  
			  String status="Y";
			     Integer updateStatus = planRepo.updateStatusById(id, status);
			     System.out.println(updateStatus);
//			    if(updateStatus .getActiveSwitch().equalsIgnoreCase("Y")) {
//			    	return "Activate successfully";
//			    }
//			    else {
//			    	return "Not Activate";
//		    }
			     return "Activate successfully";
	  }
		}
		
	return "Unable to complete soft delete";
	}

}
