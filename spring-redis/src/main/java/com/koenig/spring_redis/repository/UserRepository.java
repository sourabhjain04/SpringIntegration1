package com.koenig.spring_redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koenig.spring_redis.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
