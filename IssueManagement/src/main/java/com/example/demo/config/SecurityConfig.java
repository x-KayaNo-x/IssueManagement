package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests().antMatchers("/login").permitAll()
			.antMatchers("/user/**").hasAuthority("ADMIN")
			.anyRequest().authenticated();
		
		http
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/");
		
		http
			.logout()
			.logoutUrl("logout")
			.logoutSuccessUrl("/");
			
	}
	 @Override
	    public void configure(WebSecurity web) throws Exception {
	        web
	            .ignoring()
	            .antMatchers("/h2-console/**");
	    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
			
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
