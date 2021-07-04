package in.Insurance.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.Insurance.Entity.AccountRegistrationEntity;

public interface AccountRegistrationRepository extends JpaRepository<AccountRegistrationEntity, Serializable> {

}
