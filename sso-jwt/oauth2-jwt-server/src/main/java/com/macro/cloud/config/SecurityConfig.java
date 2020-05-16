package com.macro.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity配置
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http// 配置登陆页/login并允许访问
            .formLogin().loginPage("/login").permitAll()
            // 登出页
            .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true).deleteCookies("OAUTH2-CLIENT-SESSIONID")
            // 配置其他路径
            .and().authorizeRequests()
            .antMatchers("/oauth/**", "/login/**", "/logout/**","user/**").permitAll()
            // 其余所有请求全部需要鉴权认证
            .anyRequest().authenticated()
            // 由于使用的是JWT，我们这里不需要csrf
            .and().csrf().disable();
    }
}
