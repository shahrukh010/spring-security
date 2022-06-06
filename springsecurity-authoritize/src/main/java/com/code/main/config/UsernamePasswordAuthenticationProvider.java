package com.code.main.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.code.main.model.Authority;
import com.code.main.model.Customer;
import com.code.main.repository.CustomerRepository;

@Component // because of automatic spring security detect User define
			// AutheticationProvider.
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomerRepository repo;

	/**
	 * Override Default authentication provider as we know default authentication
	 * provider is DaoAuthenticaitonProvider. if you debug AuthenticationProvider
	 * inside authentication on loop provider you will see
	 * UsernamePasswordAuthenticationProvider
	 * 
	 * Now Not required any more UserDetails, UserDetailsService.
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		Customer user = repo.findByEmail(username);
		System.out.println(user);

		if (user != null) {

			if (passwordEncoder().matches(password, user.getPwd())) {

//				List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole()));

				return new UsernamePasswordAuthenticationToken(user, password,
						getGrantedAuthorities(user.getAuthorities()));
			}
			throw new BadCredentialsException("password does not match");
		}
		throw new BadCredentialsException("user not found!");
	}

	public List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {

		List<GrantedAuthority> authority = new ArrayList<>();

		for (Authority auth : authorities) {
			authority.add(new SimpleGrantedAuthority(auth.getName()));
		}
		return authority;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

}
