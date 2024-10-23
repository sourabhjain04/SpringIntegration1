package com.koenig.spring_redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.koenig.spring_redis.entity.User;
import com.koenig.spring_redis.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Cacheable(value ="users", key ="#id")
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	
	}
	@CachePut(value ="users", key ="#user.id")
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@CacheEvict(value ="users", key ="#id")
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
