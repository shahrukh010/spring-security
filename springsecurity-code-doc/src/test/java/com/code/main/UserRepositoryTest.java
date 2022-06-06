package com.code.main;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.code.main.entity.User;
import com.code.main.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	private UserRepository repo;
	
	@Test
	public void findByEmail() {
	
		String email ="annie.khan@cognitivzen.com";
		
		User user = repo.findByEmail(email);
		System.out.println(user);
		assertThat(user).isNotNull();
		
		
		
	}
}
