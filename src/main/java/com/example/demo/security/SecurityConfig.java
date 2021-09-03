//
//package com.example.demo.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	// ou sont stocker les users
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception { // je connais les users qui ont le
//																					// droit d acces
//		BCryptPasswordEncoder pswd = getBCPE();
//		auth.inMemoryAuthentication().withUser("admin").password(pswd.encode("1250")).roles("Admin", "User");
//		auth.inMemoryAuthentication().withUser("client1").password(pswd.encode("1250")).roles("User1");
//		auth.inMemoryAuthentication().withUser("client2").password(pswd.encode("1250")).roles("User2");
//
//		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
//	}
//
//	@Override protected void configure(HttpSecurity http) throws Exception { //
//  TODO Auto-generated method stub
//  http.formLogin().defaultSuccessUrl("/operation",true);
//  
//  http.authorizeRequests().antMatchers("../static/Css/bootstrap.min.css").
//  permitAll() .antMatchers("/login*").permitAll()
//  .anyRequest().authenticated();
//  
//  }
//
//	@Bean
//	public BCryptPasswordEncoder getBCPE() {
//		return new BCryptPasswordEncoder();
//	}
//
//}
