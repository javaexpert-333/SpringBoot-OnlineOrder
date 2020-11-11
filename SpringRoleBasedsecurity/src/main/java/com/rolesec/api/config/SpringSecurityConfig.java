package com.rolesec.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rolesec.api.service.CustomUserDetails;
import com.rolesec.api.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		// http.authorizeRequests().anyRequest().authenticated().and().formLogin().permitAll();
		/*http.authorizeRequests().antMatchers("/viewUsers").authenticated().and().authorizeRequests()
				.antMatchers("/addNewUser").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin()
				.permitAll();*/
		http.httpBasic();
		/*http.authorizeRequests().antMatchers("/viewUsers/").permitAll().and().authorizeRequests().antMatchers("/addNewUser/")
				.hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().permitAll();*/
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().permitAll();
	}

	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
}
