package co.certif.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.certif.api.model.Activite;
import co.certif.api.model.Tag;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long>, PagingAndSortingRepository<Activite, Long>{
	
	Page<Activite> findAll(Pageable pageable);
			
	Page<Activite> findAllByNomActiviteLike(Pageable pageable, String nomActivite);
	
	List<Activite> findByTag(Tag tag, Sort sort);

	
}
