package com.tourism.tourism.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.tourism.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUserName(String userName);

}
