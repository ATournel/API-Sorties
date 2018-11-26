package co.certif.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.certif.api.model.Tag;
import co.certif.api.repository.TagRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/citycrunch/tags")
public class TagController {

	@Autowired
	private TagRepository tagRepo;
	
	@CrossOrigin
	@GetMapping("/all")
	public List<Tag> getAllTags() {
		return tagRepo.findAll();
	}
	

}
