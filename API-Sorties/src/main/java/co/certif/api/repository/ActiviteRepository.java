package co.certif.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.certif.api.model.Activite;
import co.certif.api.model.Tag;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long> {
	
	List<Activite> findByTag(Tag tag);
	
}
