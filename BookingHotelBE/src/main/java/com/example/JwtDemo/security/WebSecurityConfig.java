package com.example.JwtDemo.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.example.JwtDemo.security.jwt.AuthEntryPointJwt;
import com.example.JwtDemo.security.jwt.AuthTokenFilter;
import com.example.JwtDemo.security.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
//	     securedEnabled = true,
//	     jsr250Enabled = true,
	    prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}

	 @Bean
	 public PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
	 }  
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		 http.cors().and().csrf().disable()
		 .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		 .authorizeRequests().antMatchers("/api/auth/**").permitAll()
		 .antMatchers("/api/test/**").permitAll()
		 .anyRequest().authenticated();

		 http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		 
		 http.cors().configurationSource(request -> {
	            final CorsConfiguration cors = new CorsConfiguration();
	            cors.setAllowedOrigins(Arrays.asList("http://localhost:8081/"));
	            cors.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
	            cors.setAllowCredentials(true);
//	            cors.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type", TokenAuthService.AUTH_HEADER_NAME, "x-file-name"));
//	            cors.setExposedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type", TokenAuthService.AUTH_HEADER_NAME, "x-file-name"));
	            return cors;
	        });
	        http.csrf().disable();
	 }

}
