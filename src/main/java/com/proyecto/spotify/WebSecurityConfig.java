package com.proyecto.spotify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// El endpoint que nos ofrece spring security por defaul es localhost:8080/ouath/token y siempre es el metodo post (para probar en postman igual)


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${api.username}")// @Value sirve para leer propiedades que declaramos en application.properties
    private String userName;
    @Value("${api.password}")
    private String userPassword;
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser(userName)
                .password(passwordEncoder().encode(userPassword))// valida si los password codificados son iguales
                .roles("USER");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
