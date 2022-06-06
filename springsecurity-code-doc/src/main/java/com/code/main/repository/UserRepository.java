package com.code.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.code.main.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

//	@Query("SELECT u FROM User u Where u.email=:email")
//	public User findByEmail(@Param(value="email")String email);
	public User findByEmail(String username);

}
