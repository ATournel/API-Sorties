package co.certif.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.certif.api.model.User;
import java.lang.String;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByMailUser(String mailuser);
	
}
