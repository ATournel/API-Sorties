package co.certif.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.certif.api.model.Activite;
import co.certif.api.repository.ActiviteRepository;
import co.certif.api.repository.TagRepository;

@RestController
@RequestMapping("/citycrunch/activite")
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
	
	@CrossOrigin
	@GetMapping("/all")
	public List<Activite> getActivites() {
		return actiRepo.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Activite getActiviteById(@PathVariable(value="id") Long id) {
		return actiRepo.findOne(id);
	}
	
	@CrossOrigin
	@GetMapping("/tag={idTag}")
	public List<Activite> getActivitesByTag(@PathVariable(value="idTag") Long idTag) {
		return actiRepo.findByTag(tagRepo.findOne(idTag));
	}
	
}
