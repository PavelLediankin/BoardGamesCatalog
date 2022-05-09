package com.example.BoardGameProject.config;

import com.example.BoardGameProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        configurePostDeleteMethods(httpSecurity, "/customer", "CUSTOMER");
        configurePostDeleteMethods(httpSecurity, "/category", "STORE");
        configurePostDeleteMethods(httpSecurity, "/game", "STORE");
        configurePostDeleteMethods(httpSecurity, "/producer", "STORE");
        configurePostDeleteMethods(httpSecurity, "/store", "STORE");

        httpSecurity
                .csrf()
                    .disable()
                .authorizeRequests()
                    //Доступ только для не зарегистрированных пользователей
                    .antMatchers("/registration").not().fullyAuthenticated()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/", "/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                    .logoutSuccessUrl("/");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

    private void configurePostDeleteMethods(HttpSecurity httpSecurity, String path, String role) throws Exception
    {
        httpSecurity
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, path).hasRole(role)
                    .antMatchers(HttpMethod.DELETE, path).hasRole(role);
    }
}
