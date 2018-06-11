package com.example.sudhar.springbootscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
public class SpringBootSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchedulerApplication.class, args);
	}

	@Bean
    public WebSecurityConfigurerAdapter webSecurityConfig(DataSource dataSource) {
	    return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable()
                        .authorizeRequests()
                        .antMatchers("/h2-console/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        .and().formLogin()
                        .and().headers().frameOptions().sameOrigin();
            }

            @Override
            protected void configure(AuthenticationManagerBuilder builder) throws Exception {
                builder.jdbcAuthentication().dataSource(dataSource);
            }
        };
    }
}
