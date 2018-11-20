package co.certif.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.certif.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
