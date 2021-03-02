package br.com.sitoni.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter  {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	String passwordencodedAdmin  = passwordEncoder().encode("123456");
        
        
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("admin")
                .password(passwordencodedAdmin)
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
    	http.csrf().disable()
    	.authorizeRequests()
    	.antMatchers("/person/**")
        .hasAnyRole("USER", "ADMIN")
    	.antMatchers("/source/**","/h2-console/**", "/swagger-ui/**")
    	.permitAll()
    	.and()
    	.headers().frameOptions().disable().and()
    	.httpBasic();
    }
    
    
}




