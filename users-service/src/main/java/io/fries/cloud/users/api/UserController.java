package io.fries.cloud.users.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "", produces = "application/json")
	private List<User> getAll() {
		return userService.getAll();
	}
	
	@RequestMapping(path = "/{index}", produces = "application/json")
	private User get(@PathVariable int index) {
		return userService.get(index);
	}
}
