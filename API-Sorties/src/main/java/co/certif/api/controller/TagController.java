package co.certif.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.certif.api.model.Tag;
import co.certif.api.repository.TagRepository;
import co.certif.api.repository.UserRepository;

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
		
	@CrossOrigin
	@GetMapping("/{idTag}")
	public Tag getOneTag(@PathVariable(value="idTag") Long idTag) {
		return tagRepo.findOne(idTag);
	}
	
	//Create Tag
	@CrossOrigin
	@PostMapping("/new")
	public void createTag(@RequestBody Tag tag) {
		tagRepo.save(tag);
	}
	
	//Update Tag
	@CrossOrigin
	@PostMapping("/update")
	public void updateTag(@RequestBody Tag tag) {
		tagRepo.updateTag(tag);
	}
	
	//Delete Tag
	@CrossOrigin
	@DeleteMapping("/delete/{idTag}")
	public void deleteTag(@PathVariable(value="idTag") Long idTag) {
		tagRepo.delete(idTag);
	}
}
