package io.fries.cloud.client.users;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
	List<User> getAll();
	User get(Integer index);
	
	User getRandom();
}
