package co.certif.api.controller;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.certif.api.model.Tag;
import co.certif.api.model.User;
import co.certif.api.repository.TagRepository;
import co.certif.api.repository.UserRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("citycrunch")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private TagRepository tagRepo;
	
	
	//Save a user into the database
	@CrossOrigin
	@PostMapping("/signup")
	User createUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	//Get user by its mail
	@CrossOrigin
	@GetMapping("/{mailUser}")
	User getUser(@PathVariable(value="mailUser") String mailUser) {
		return userRepo.findByMailUserLike(mailUser+".%");
	}
	
	//Get user by its id
	@CrossOrigin
	@GetMapping("/profil/{idUser}")
	User getConnectedUser(@PathVariable(value="idUser") Long idUser) {
		return userRepo.findOne(idUser);
	}
	
	//Get user by its sign in	
	@CrossOrigin
	@PostMapping("/signin")
	public boolean getUserSignIn(@RequestBody User signInUser) {
		boolean success=false;
		User bddUser = userRepo.findByMailUserLike(signInUser.getMailUser());
		if (bddUser != null) {

			if(signInUser.getPassword().equals(bddUser.getPassword())) {
			//	System.out.println("ok!");
				success=true;
			}
			else {
			//	System.out.println("not ok!");
			}
		}
		else {
		//	System.out.println("User not found!");
		}
		System.out.println(success);
		return success;
	}
	
	//Get User Tags
	@CrossOrigin
	@GetMapping("/profil/{idUser}/tags")
	public Collection<Tag> getUserTags(@PathVariable(value="idUser") Long idUser) {
		return userRepo.findOne(idUser).getTags();
	}
	
	//Delete a user's tag
	@CrossOrigin
	@DeleteMapping("/profil/{idUser}/delete/{idTag}")
	public @ResponseBody void deleteAUserTag(@PathVariable(value="idUser") Long idUser, @PathVariable(value="idTag")  Long idTag) {
		User user = userRepo.findOne(idUser);
		Tag tag = tagRepo.findOne(idTag);
		
		user.getTags().remove(tag);
		userRepo.save(user);
	}
	
	//Add a user tag
	@CrossOrigin
	@GetMapping("/profil/{idUser}/add/{idTag}")
	public void addUserTag(@PathVariable(value="idUser") Long idUser, @PathVariable(value="idTag")  Long idTag) {
		User user = userRepo.findOne(idUser);
		Tag tag = tagRepo.findOne(idTag);
		
		List<Tag> userTags = (List<Tag>) user.getTags();
		userTags.add(tag);
		user.setTags(userTags);
		
		userRepo.save(user);
	}
	
}
