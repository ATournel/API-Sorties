package co.certif.api.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.hibernate.annotations.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.certif.api.model.Activite;
import co.certif.api.model.Tag;
import co.certif.api.repository.ActiviteRepository;
import co.certif.api.repository.TagRepository;
import co.certif.api.repository.UserRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/citycrunch/activites")
public class ActiviteController {

	@Autowired
	private ActiviteRepository actiRepo;
	@Autowired
	private TagRepository tagRepo;
	@Autowired
	private UserRepository userRepo;
	
	//Read all activities
	@CrossOrigin
	@GetMapping("/all")
	public Page<Activite> getActivites(int page, int size, Sort sort) {
		return actiRepo.findAll(new PageRequest(page, size, sort));
	}
	
	//Read one activity using its id
	@CrossOrigin
	@GetMapping("/{id}")
	public Activite getActiviteById(@PathVariable(value="id") Long id) {
		return actiRepo.findOne(id);
	}
	
	//Read all activities with "On a testé"
	@CrossOrigin
	@GetMapping("/nom={nomActivite}")
	public Page<Activite> getActiviteTestees(int page, int size, Sort sort, @PathVariable(value="nomActivite") String nomActivite) {
		return actiRepo.findAllByNomActiviteLike(new PageRequest(page, size, sort), nomActivite+"%");
	}
	
	
	//Read all activities with the specified tag
	@CrossOrigin
	@GetMapping("/tag={idTag}")
	@OrderBy(clause = "date_activite DESC")
	public List<Activite> getActivitesByTag(@PathVariable(value="idTag") Long idTag) {
		return actiRepo.findByTag(tagRepo.findOne(idTag), new Sort(Sort.Direction.DESC, "dateActivite"));
	}
	
	//Get User Suggestions
	@CrossOrigin
	@GetMapping("/sugg/user={idUser}")
	List<Activite> findByUserTags(@PathVariable(value="idUser") Long idUser) {
		List<Tag> userTags = (List<Tag>) userRepo.findOne(idUser).getTags();
		List<Activite> userSuggestions = new ArrayList<Activite>();
		for(int i=0; i<userTags.size(); i++) {
			userSuggestions.addAll(actiRepo.findByTag(userTags.get(i), new Sort(Sort.Direction.DESC, "dateActivite")));
		}
		return userSuggestions;
	}
	
	//Create an activity
	@CrossOrigin
	@PostMapping("/new")
	public void createActivite(@RequestBody Activite activite) {
		actiRepo.save(activite);
	}
	
	//Update an activity
	@CrossOrigin
	@PostMapping("/update")
	public void updateActivite(@RequestBody Activite activite) {
		actiRepo.updateActivite(activite);
	}
	
	//Delete an activity using its id
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public void deleteActivite(@PathVariable(value="id") Long id) {
		actiRepo.delete(id);
	}
	
}
