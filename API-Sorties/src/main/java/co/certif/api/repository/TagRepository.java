package co.certif.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.certif.api.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
