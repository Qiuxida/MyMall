package com.star.mall.config;

import com.star.mall.filter.JwtAuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;

/**
 * SpringSecurity配置类
 * @author StarQ
 * @since 2021-03-10
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    UserDetailsService userDetailsService;

    @Bean
    public CorsFilter corsFilter() {
        // 创建CORS配置信息对象
        CorsConfiguration config = new CorsConfiguration();

        /***************设置跨域需要配置的属性***************/
        // 添加允许的域,如果需要使用cookie不要写*，否则cookie就无法使用了
        config.addAllowedOrigin("*");
        // 添加允许的请求方式
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        // 添加允许的头信息
        config.addAllowedHeader("*");
        // 设置否发送Cookie信息
        config.setAllowCredentials(false);
        /***************设置跨域需要配置的属性***************/

        // 添加映射路径，拦截所有请求
        UrlBasedCorsConfigurationSource configSource =
                new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        // 返回一个配置号的跨域过滤器
        return new CorsFilter(configSource);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/api/v1/login").permitAll()
                .anyRequest().authenticated();

        httpSecurity.headers().cacheControl();
        httpSecurity.logout().logoutUrl("/logout");
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
