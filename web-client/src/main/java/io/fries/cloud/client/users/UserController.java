package io.fries.cloud.client.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "")
	public User index() {
		return userService.getRandom();
	}
}
