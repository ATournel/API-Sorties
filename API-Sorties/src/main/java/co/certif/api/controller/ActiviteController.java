package co.certif.api.controller;

import java.util.List;


import org.hibernate.annotations.OrderBy;
import org.skife.jdbi.v2.sqlobject.customizers.MaxRows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.certif.api.model.Activite;
import co.certif.api.repository.ActiviteRepository;
import co.certif.api.repository.TagRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/citycrunch/activites")
public class ActiviteController {

	@Autowired
	private ActiviteRepository actiRepo;
	@Autowired
	private TagRepository tagRepo;
	/*
	public ActiviteController(ActiviteRepository actiRepo) {
		super();
		this.actiRepo = actiRepo;
	}*/
	
	//Read all activities
	@CrossOrigin
	@GetMapping("/all")
	@OrderBy(clause = "date_activite DESC")
	public List<Activite> getActivites() {
		return actiRepo.findAll(new Sort(Sort.Direction.DESC, "dateActivite"));
	}
	
	//Read one activity using its id
	@CrossOrigin
	@GetMapping("/{id}")
	public Activite getActiviteById(@PathVariable(value="id") Long id) {
		return actiRepo.findOne(id);
	}
	
	//Read all activities with the specified tag
	@CrossOrigin
	@GetMapping("/tag={idTag}")
	public List<Activite> getActivitesByTag(@PathVariable(value="idTag") Long idTag) {
		return actiRepo.findByTag(tagRepo.findOne(idTag), new Sort(Sort.Direction.DESC, "dateActivite"));
	}
	
	//Delete an activity using its id
	@CrossOrigin
	@DeleteMapping("/{id}")
	public void deleteActivite(@PathVariable(value="id") Long id) {
		actiRepo.delete(id);
	}
	
}
