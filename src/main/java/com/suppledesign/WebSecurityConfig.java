package com.suppledesign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .headers().frameOptions().disable().and()
            .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .and()
            .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .csrf().ignoringAntMatchers("/h2-console/**")
                .and()
            .formLogin()
                .loginPage("/login").permitAll()
                .and()
            .logout()
                .permitAll();
    }

//    // in memory
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("password").roles("ADMIN");
//    }


//    // USERS, AUTHORITIES (デフォルト) テーブルを参照してログイン処理を行う
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .jdbcAuthentication()
//                .dataSource(dataSource);
//    }


    // 独自のテーブルを利用してログイン処理を行う
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder())
        ;
    }

//    public static void main(String[] args) {
//        System.out.println(BCrypt.hashpw("password", BCrypt.gensalt()));
//        System.out.println(BCrypt.hashpw("password", BCrypt.gensalt()));
//        System.out.println(BCrypt.hashpw("password", BCrypt.gensalt()));
//    }

}
