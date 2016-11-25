package io.fries.cloud.users.api;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
class UserServiceImpl implements UserService {
	
	private final List<User> users = Arrays.asList(
		new User("John", "Doe"),
		new User("Ano", "Nymous")
	);
	
	@Override
	public List<User> getAll() {
		return users;
	}
	
	@Override
	public User get(int index) {
		return users.get(index);
	}
}
