package com.code.main.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {

////****************************************************************************************************
//		// path level security we can customize using antMatchers(String string)
////****************************************************************************************************
//
		// you can use default CustomUserService and CustomUserDetails authentication
//		http.authorizeRequests().antMatchers("/api/balance")
//		.authenticated().antMatchers("/api/loan")
//		.authenticated()
//		.antMatchers("/api/contact").permitAll().antMatchers("/api/info")
//		.authenticated().and().formLogin()
//		.and().httpBasic();
		
		
		//authorities based configuration
		
		http.authorizeRequests()
		.antMatchers("/api/balance").hasAuthority("rwx")
		.antMatchers("/api/loan").hasAuthority("rw")
		.antMatchers("/api/info").authenticated()
		.antMatchers("/api/contact").permitAll()
		.and().formLogin().and().httpBasic();

		// any request come from http whether username and password is contain or not
		// denyall request from http
//		http.authorizeRequests().anyRequest().denyAll()
//		.and().formLogin().and().httpBasic();

		// permit all request whether authentication have or not
//		http.authorizeRequests().anyRequest().permitAll().and().formLogin().and().httpBasic();
//		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").usernameParameter("email").permitAll();

//		http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();

	}

//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
//		
//		//here if you want to  customize UserDetails,UserDetailsService ,authenticaionProvider ,PasswordEncoder related details
//		
//		
//		//below i m going to overide application.properties file username,password
//		
//	
//		auth.inMemoryAuthentication().withUser("annie").password("hector").authorities("rwx").and()
//		.withUser("bridget").password("nic").authorities("rw").and()
//		.passwordEncoder(NoOpPasswordEncoder.getInstance());
//		
//		/**
//		 * .authorities:is mandatory is pass GrantedAuthority can not be null
//		 * .passwordEncoder we have to pass because id can not be null if you implement seperately PasswordEncoder then not required to pass here it will auto detect
//		 * 
//		 * here auth also override application.properties security like username,password
//		 */
//	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
////****************************************************************************************************		
//
//		List<GrantedAuthority> authorites = new ArrayList<>();
//		authorites.add(new SimpleGrantedAuthority("rwx"));
//
//		List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("rw"));
//		// SimpleGrantedAuthority is implemented class of GrantedAuthority interface
//
//		Collection<GrantedAuthority> role = List.of(new SimpleGrantedAuthority("wx"));
//
////****************************************************************************************************		
//
//		// other way we can implement inMemory authentication also
//		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//		UserDetails user1 = User.withUsername("shahrukh").password("khan").authorities("rwx").build();
//		UserDetails user2 = User.withUsername("khan").password("shahrukh").authorities("rw").build();
//		UserDetails user3 = new User("annie", "hector", role);
//
//		userDetailsManager.createUser(user1);// fetching the user from UserDetails and store details inside Memory
//												// location
//		userDetailsManager.createUser(user2);// storing user into memory location.
//		userDetailsManager.createUser(user3);
////		userDetailsManager.updatePassword(user3, "a3e2d5da");
//		userDetailsManager.deleteUser("annie");// delete facebook account
//		System.out.println(userDetailsManager.userExists("annie"));
//
//		auth.userDetailsService(userDetailsManager);// passing UserDetailsManager to UserDetailsService to manage
//													// authentication otherwise spring security manage default way to
//													// authentication
//
//		/**
//		 * User is class implements UserDetails ,UserDetails or User used to provide
//		 * user schema,like username,password,role UserDetailsManager:->responsible to
//		 * createUser,updateUser,deleteUser,changePassword
//		 * InMemoryUserDetailsManager(I)extends UserDetailsManager, same like
//		 * JdbcUserDetailsManager also extends UserDetailsManager.
//		 * 
//		 * UserDetailsManager:(I)extends UserDetailsService
//		 */
//		
//		//note:InMemoryUserDetails use for just demo purpose or tmp uses because of is storeing data volatile
//
//	}

//	@Bean
//	public UserDetailsService userDetailsServie(DataSource datasource) {
//
//		return new JdbcUserDetailsManager(datasource);
//		
//		/**
//		 * DaoAuthenticationProvider is responsible to call these methods
//		 * UserDetailsService loadUser name
//		 * Datasource reading application.properties file to load database related information.
//		 * 
//		 */
//		
//		/**
//		 * make sure before use JdbcUserDetailsManager you have created proper users and column in to database
//		 * same as default which is provided by spring framework in JdbcUserDetailsManager class ex:Users(id,username,password,role)
//		 */
//	}

//	private UserDetailsService userDetaisService() {
//
//		return new CustomUserDetailService();
//
//	}

	/**
	 * till here you can see client enter password and username and loadByUsername
	 * with client username goting to repository layer and getting object of passed
	 * by argument and provided to UserDetails and then matches. there no any kind
	 * of secuirty like encryption,integrity
	 * 
	 * @return
	 */

}
