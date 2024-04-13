package com.example.boot2.config.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    HandlerLoginSucess handlerLoginSucess;

    @Autowired
    HandlerLoginFailure handlerLoginFailure;

    @Autowired
    HandlerLogoutSucess handlerLogoutSucess;

    @Autowired
    HandlerAccessDeny handlerAccessDeny;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http
                .csrf((csrfConfig) ->
                        csrfConfig.disable()
                )
                .headers((headerConfig) ->
                        headerConfig.frameOptions(frameOptionsConfig ->
                                frameOptionsConfig.disable()
                        )
                )
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/", "/home", "/comm/**", "/img/**", "/css/**", "/js/**", "/docs/**", "/secure/login").permitAll()
                                .requestMatchers("/study/**").hasAnyRole("MEMBER", "ADMIN")
                                .requestMatchers("/member/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .exceptionHandling((exceptionConfig) ->
                        exceptionConfig.accessDeniedHandler(handlerAccessDeny)
                )
                .formLogin((formLogin) ->
                        formLogin
                                .loginPage("/secure/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .loginProcessingUrl("/secure/login_exe")
                                .defaultSuccessUrl("/", true)
                )
                .logout((logoutConfig) ->
                        logoutConfig.logoutSuccessUrl("/")
                                .permitAll()
                );

        return http.build();
    }
}