package in.Insurance.Repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.Insurance.Entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Serializable> {

	@Transactional
	//git trial bfrom repo
	@Modifying
	@Query("update PlanEntity set activeSwitch=:status where planId=:id")
	public Integer updateStatusById(Integer id,String status);
	
}
