package com.hoy.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.headers().frameOptions().disable();
        http.authorizeRequests().antMatchers("/").access("#oauth2.hasScope('webclient')").anyRequest().authenticated();

    }
}
