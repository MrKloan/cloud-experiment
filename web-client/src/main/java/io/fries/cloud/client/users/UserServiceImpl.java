package io.fries.cloud.client.users;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
class UserServiceImpl implements UserService {
	
	private static final String USERS_SERVICE_NAME = "USERS-SERVICE";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "hystrixFallback")
	@Override
	public List<User> getAll() {
		return restTemplate.getForObject(url("/users"), List.class);
	}
	
	@HystrixCommand(fallbackMethod = "hystrixFallback")
	@Override
	public User get(Integer index) {
		return restTemplate.getForObject(url("/users/" + index), User.class);
	}
	
	@Override
	public User getRandom() {
		List<User> users = getAll();
		int index = new Random().nextInt(users.size());
		
		return get(index);
	}
	
	private Object hystrixFallback(Map<String, Object> parameters) {
		return null;
	}
	
	private String url(String endpoint) {
		return "http://" + USERS_SERVICE_NAME + endpoint;
	}
}
