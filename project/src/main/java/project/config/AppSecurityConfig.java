package project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import project.security.CustomAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
       // new BCryptPasswordEncoder()
    }

    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    public AppSecurityConfig( CustomAuthenticationSuccessHandler authenticationSuccessHandler){
       this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                //.anyRequest()

               .antMatchers("/users/**")
               .access("hasRole('ROLE_USER')")
                .antMatchers("/orders/**")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/products/**")
                .access("hasRole('ROLE_USER')")
               .antMatchers("/admin/**")
               .access("hasRole('ROLE_ADMIN')")
                .and()
               .formLogin()

                 //.loginPage("home/login")
                .successHandler(authenticationSuccessHandler)
                .permitAll()
                .and()
                .rememberMe()
                .and()
                .logout()
                .permitAll();
        return httpSecurity.build();
    }


}
