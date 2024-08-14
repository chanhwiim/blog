package com.nhnacademy.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**
     * 로그인, 로그아웃 추가 필요.
     * 어떤 url을 허용할지 추가 필요.
     * 어떤 요청은 인증이 필요하고, 어떤 요청은 인증이 불필요한지 설정 필요.
     * 어떤 url에서 값을 받을지 설정 필요.
     * TODO: Controller에서 path를 설정 한 뒤, 추가 작업.
     *
     * @param httpSecurity
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .build();
    }
}
