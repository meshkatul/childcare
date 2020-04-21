package org.perscholas.childcare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	 http.csrf().disable()
    	 .authorizeRequests()
                .antMatchers(
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                    .defaultSuccessUrl("/index")
                .and()
                .logout().permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/home");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("ava@gmail.com").password("{noop}password").roles("PARENT")
                .and()
                .withUser("chris@gmail.com").password("{noop}password").roles("PARENT")
                .and()
                .withUser("imran@gmail.com").password("{noop}password").roles("PARENT")
                .and()
                .withUser("diana@gmail.com").password("{noop}password").roles("PARENT")
                .and()
                .withUser("mark@gmail.com").password("{noop}password").roles("PARENT")
                .and()
                .withUser("arif844@gmail.com").password("{noop}password").roles("PARENT")
                .and()
                .withUser("abc@gmail.com").password("{noop}password").roles("PARENT")
                .and()
                .withUser("john@gmail.com").password("{noop}password").roles("PARENT")
                .and()
                .withUser("admin@hma.com").password("{noop}admin").roles("ADMIN");
    }
}

	
