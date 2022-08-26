package com.sintoli.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.sintoli.security.CustomUserDetailsService;

@Configuration
public class WebSecurityCongfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override
protected void configure(HttpSecurity http) throws Exception{
	http.csrf().disable()
	           .authorizeRequests()
	           .antMatchers("/login", "/register").permitAll()
	           .anyRequest().authenticated()
	           .and()
	           .httpBasic();
}
	@Override
protected void	configure(AuthenticationManagerBuilder auth)throws Exception{
		//first method
//	auth.inMemoryAuthentication()
//	    .withUser("anand").password("1234").authorities("admin")
//	    .and()
//	    .withUser("arun").password("1234").authorities("user");
		
		//Second method
//		InMemoryUserDetailsManager userDetailsManager=new InMemoryUserDetailsManager();
//		UserDetails user1=User.withUsername("anand").password("1234").authorities("admin").build();
//		UserDetails user2=User.withUsername("aman").password("1234").authorities("admin").build();
//		userDetailsManager.createUser(user1);
//		userDetailsManager.createUser(user2);
//		auth.userDetailsService(userDetailsManager);
	
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	@Override
public 	AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
