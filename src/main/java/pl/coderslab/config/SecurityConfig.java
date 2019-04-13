package pl.coderslab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import pl.coderslab.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailService userDetailService;

    public SecurityConfig(MyUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        /*http.authorizeRequests()
                .antMatchers("/", "/login", "/perform_login", "/logout", "/perform_logout")
                .permitAll();*/

        http.authorizeRequests()
                .antMatchers("/user/*").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        http.authorizeRequests()
                .antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')");

       /* http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");*/

        http.authorizeRequests().and()
                .formLogin()
                .loginProcessingUrl("/perform_login")
                .loginPage("/login")
                .defaultSuccessUrl("/user/dashboard")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");

        /*http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(24 * 60 * 60); // 24h*/

        /*http.authorizeRequests()
                .antMatchers("/console/**")
                .permitAll();*/

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        return new InMemoryTokenRepositoryImpl();
    }
}
