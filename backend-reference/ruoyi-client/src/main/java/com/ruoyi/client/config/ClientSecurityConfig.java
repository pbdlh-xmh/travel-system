package com.ruoyi.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class ClientSecurityConfig {

    @Value("${client.token.secret}")
    private String secret;

    @Bean(name = "clientAccessTokenConverter")  // 添加一个特定的bean名称，避免与后台的冲突
    public JwtAccessTokenConverter clientAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(secret);
        return converter;
    }
}