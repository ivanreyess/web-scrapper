package com.sv.webscrapper.config;

import com.sv.webscrapper.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

	public static final String DEVELOPER = "USER";

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests(authConfig -> {
				authConfig.requestMatchers(HttpMethod.GET, "/", "/login", "/error", "/login-error", "/logout", "/css/**", "/ui/user").permitAll();
				authConfig.requestMatchers(HttpMethod.POST,  "/ui/user").permitAll();
				authConfig.requestMatchers(HttpMethod.GET, "/user").hasRole("USER");
				authConfig.requestMatchers(HttpMethod.GET, "/admin").hasRole("ADMIN");
				authConfig.requestMatchers(HttpMethod.GET, "/developer").hasRole(DEVELOPER);
				authConfig.requestMatchers(HttpMethod.GET, "/users").hasAnyRole(DEVELOPER);
				authConfig.requestMatchers(HttpMethod.GET, "/authorities").hasAnyRole(DEVELOPER);
				authConfig.anyRequest().authenticated();
			})
			.formLogin(login -> {
				login.loginPage("/login");
				login.defaultSuccessUrl("/ui/pages");
				login.failureUrl("/login-error");
				}
			)
			.logout(logout -> {
				logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
				logout.logoutSuccessUrl("/");
				logout.deleteCookies("JSESSIONID");
				logout.invalidateHttpSession(true);
			});
		return http.build();
	}
	
	@Bean
	UserDetailsService myUserDetailsService(UserRepository userRepository) {
		return new MyUserDetailsService(userRepository);
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityEvaluationContextExtension securityEvaluationContextExtension() {
		return new SecurityEvaluationContextExtension();
	}
	
	@Bean
	ApplicationListener<AuthenticationSuccessEvent> successEvent() {
		return event -> log.info("Success Login " + event.getAuthentication().getClass().getSimpleName() + " - " + event.getAuthentication().getName());
	}
	
	@Bean
	ApplicationListener<AuthenticationFailureBadCredentialsEvent> failureEvent() {
		return event -> log.error("Bad Credentials Login " + event.getAuthentication().getClass().getSimpleName() + " - " + event.getAuthentication().getName());
	}
}
