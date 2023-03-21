package br.unioeste.ministockback.configs;

import br.unioeste.ministockback.models.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/**","/swagger-ui/**","/v3/**")
                .permitAll()
                .requestMatchers(HttpMethod.GET)
                .permitAll()
                .requestMatchers("/product/**", "/purchase/**")
                .hasAnyAuthority(Role.STOCK_MANAGER.name())
                .requestMatchers("/sale/**")
                .hasAnyAuthority(Role.SELLER.name())
                .requestMatchers("/type/**","/customer/**", "/supplier/**")
                .hasAnyAuthority(Role.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return security.build();
    }
}
