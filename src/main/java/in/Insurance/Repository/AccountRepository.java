package in.Insurance.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.Insurance.Entity.AccountEntity;

public interface AccountRepository  extends JpaRepository<AccountEntity, Serializable>{

	
	public List<AccountEntity> findByRole(String role);
	
	
	@Query("from AccountEntity where email=:email And password=:password")
	public AccountEntity findByEmailAndPassword(String email,String password);
	
	
	public AccountEntity findByEmail(String email);
}
