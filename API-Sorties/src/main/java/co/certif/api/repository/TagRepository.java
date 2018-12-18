package co.certif.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.certif.api.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

	default void updateTag(Tag tag) {
		Tag previousTag = findOne(tag.getIdTag());
		if(tag.getIntituleTag() !=null) {
			previousTag.setIntituleTag(tag.getIntituleTag());
		}
		save(previousTag);
	}

	/*//Trying to get a user's tag list
	@Query("from User as user inner join fetch user.tags where user.idUser=1")
	List<Tag> findByIdUser();
	*/
}
