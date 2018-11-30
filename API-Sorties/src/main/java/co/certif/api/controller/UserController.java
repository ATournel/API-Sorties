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
	
	
	//Get user by its sign in
	
	@CrossOrigin
	@PostMapping("/signin")
	public User getUserSignIn(@RequestBody User signInUser) {
		User bddUser = userRepo.findByMailUser(signInUser.getMailUser());
		if (bddUser != null) {

			if(signInUser.getPassword().equals(bddUser.getPassword())) {
				System.out.println("ok!");
			}
			else {
				System.out.println("not ok!");
			}
		}
		else {
			System.out.println("User not found!");
		}
		return bddUser;
	}
	
}
