package com.code.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityCustomer extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/myAccount").hasRole("USER")//spring-boot automatically add prefix like ROLE_USER not required to provide 
		.antMatchers("/myBalance") .hasAnyRole("ADMIN","USER")//prefix we added into our database side like ROLE_USER,ROLE_ROOT,it must be prefix ROLE_XXXX,otherwise not worked it is testd.
		.antMatchers("/myLoans").hasRole("ROOT")
		.antMatchers("/myCards").authenticated().antMatchers("/notices").permitAll()
		.antMatchers("/contact").permitAll().and().formLogin().and().httpBasic();
	}

//	@Bean
//	public PasswordEncoder passwordEcoder() {
//
//		return new BCryptPasswordEncoder();
//}

}
