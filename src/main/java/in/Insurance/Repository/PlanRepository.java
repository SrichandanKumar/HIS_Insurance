package in.Insurance.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.Insurance.Entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Serializable> {

	//git trial bfrom repo
	
	@Query("update PlanEntity set activeSwitch=:status where planId=:id")
	public boolean deleteById(Integer id,String status);
	
}
