package qr.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import qr.services.SecurityFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .requestCache(RequestCacheConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/",
                                "/**",
                                "/worker-assistance/**",
                                "/swagger-ui.html",
                                "/swagger-resources/**"
                        )
                        .permitAll()
                )
                .logout(logout -> logout.logoutUrl("session-logout"));
        return http.build();
    }

    @Bean
    public FilterRegistrationBean<SecurityFilter> logFilter() {
        FilterRegistrationBean<SecurityFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SecurityFilter());
        registrationBean.addUrlPatterns("/swagger-ui.html","/swagger-ui/*","/worker-assistance/**");
        return registrationBean;
    }
}
