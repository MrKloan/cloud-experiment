package io.fries.cloud.users.api;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
	List<User> getAll();
	User get(int index);
}
