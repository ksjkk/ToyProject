package com.ildong.oracle.infrastructure;

import com.ildong.oracle.auth.PrincipalDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity  // 시큐리티 필터가 등록 / 시큐리티는 발동, 설정을 여기서
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 특정주소로 접근을 하면 권한 및 인증을 미리 체크
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private PrincipalDetailService principalDetailService;

    public SecurityConfig(PrincipalDetailService principalDetailService){
        this.principalDetailService = principalDetailService;
    }

    @Bean
    public BCryptPasswordEncoder encoderPWD(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 시큐리티가 대신 로그인 password intercept
     * 해당 password가 뭘로 해쉬가 되어 로그인이 되었나
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(encoderPWD());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/auth").hasRole("USER")
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login")                // any Request는 여기로 온다
                .loginProcessingUrl("/auth/ad")     // 스프링 시큐리티가 해당주소로 요청오는 로그인을 가로채서 대신 로그인해준다
                .defaultSuccessUrl("/auth")         // 정상일때
                .usernameParameter("empno")
                .passwordParameter("password")
//                .permitAll()
//            .and()
//                .logout().permitAll()
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring().antMatchers("/templates/**");
    }

}
