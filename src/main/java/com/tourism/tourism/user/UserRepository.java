package com.tourism.tourism.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserLogin, Long>{
	Optional<UserLogin> findByUsername(String username);

	@Query("select u.id from userlogin u where u.username = :username")
	String getIdByUsername(@Param("username") String username);
}
