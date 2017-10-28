package com.terekhin.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by Nick on 27.10.17.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

}
