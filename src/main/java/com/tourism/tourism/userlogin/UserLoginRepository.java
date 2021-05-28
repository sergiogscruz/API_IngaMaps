package com.tourism.tourism.userlogin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long>{
	Optional<UserLogin> findByUsername(String username);

	@Query("select u.id from userlogin u where u.username = :username")
	Long getIdByUsername(@Param("username") String username);
}
