package co.certif.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.certif.api.model.User;
import co.certif.api.repository.UserRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("citycrunch/users")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	//Save a user into the database
	@CrossOrigin
	@PostMapping("/signup")
	User createUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	
	//Get user by its id
	@CrossOrigin
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value="id") Long id) {
		return userRepo.findOne(id);
	}
	
}
