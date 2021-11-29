package com.example.fmw.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.fmw.services.CustomUserServiceDetails;


@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserServiceDetails();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userDetailsService());
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());

		PasswordEncoder pass = passwordEncoder();

		//creation d admin par defaut
		auth.inMemoryAuthentication().withUser("admin").password(pass.encode("1234")).roles("ADMIN");

		System.out.println(pass.encode("1234"));

	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.formLogin().loginPage("/login").defaultSuccessUrl("/");
	//	http.authorizeRequests().antMatchers("/admin/edit**/**").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/admin/edit/**").hasRole("ADMIN");

		http.authorizeRequests()
				.antMatchers("/login", "/register_user", "/webjars/**", "/style2.css/**", "/style.css/**")
				.permitAll().anyRequest().authenticated().and().logout().invalidateHttpSession(true)
				.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout").permitAll();

	}

	public void configure(WebSecurity web) throws Exception {
		// web.ignoring().antMatchers("/resources/static/**").anyRequest();
	}

}
