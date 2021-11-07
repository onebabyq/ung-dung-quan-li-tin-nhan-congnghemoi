package com.example.ChatWeb.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth.inMemoryAuthentication()
                .withUser("user1").password(bCryptPasswordEncoder().encode("user1Pass")).roles("USER")
                .and()
                .withUser("user2").password(bCryptPasswordEncoder().encode("user2Pass")).roles("USER")
                .and()
                .withUser("admin").password(bCryptPasswordEncoder().encode("adminPass")).roles("ADMIN");
        // @formatter:on
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/anonymous*").anonymous()
                .antMatchers("/login*","/info").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("soDienThoai")
                .passwordParameter("password")
                .loginPage("/login")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error=true")
               // .failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID");
               // .logoutSuccessHandler(logoutSuccessHandler());
        //.and()
        //.exceptionHandling().accessDeniedPage("/accessDenied");
        //.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
        // @formatter:on
    }
    @Override
	public void configure(WebSecurity web) throws Exception {
		web
        .ignoring()
        .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**","/register","/upload/**");
	}

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//    	//auth.userDetailsService(userDetailsService);
//    }
}
	