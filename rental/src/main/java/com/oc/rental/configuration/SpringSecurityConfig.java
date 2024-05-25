package com.oc.rental.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

  private final JwtAuthenticationEntryPoint jwtAuthenticationFilter;
  private JwtAuthenticationFilter jwtAutentificationFilter;
  public SpringSecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationFilter) {
    this.jwtAuthenticationFilter = jwtAuthenticationFilter;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
      .csrf(AbstractHttpConfigurer::disable)
        .exceptionHandling(exceptionHandling->exceptionHandling.authenticationEntryPoint(jwtAuthenticationFilter))
        .httpBasic(basic -> basic.authenticationEntryPoint(jwtAuthenticationFilter()))
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeHttpRequests()
      //  .requestMatchers("/messages/**").permitAll()
       // .requestMatchers("/rentals/**").permitAll()
        //.requestMatchers("/user/**").permitAll()
        .requestMatchers("/auth/**").permitAll()
        .anyRequest().authenticated();

    http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }

  public static final String passwordEncoder = null;


  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public JwtAuthenticationEntryPoint jwtAuthenticationFilter() {
    return new JwtAuthenticationEntryPoint();
  }


}
