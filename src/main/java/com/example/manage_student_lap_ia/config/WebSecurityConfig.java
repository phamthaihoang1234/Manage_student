package com.example.manage_student_lap_ia.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class WebSecurityConfig   {

  /*  @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }*/

   /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().requestMatchers("/login").permitAll()
                .requestMatchers("/users/**", "/settings/**").hasAnyRole("Admin")
                .requestMatchers("/users/**", "/settings/**").hasAnyRole("User")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll()
                .and()
                .rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
                .and()
                .logout().permitAll();

        http.headers().frameOptions().sameOrigin();

        return http.build();
    }*/

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }*/

}
