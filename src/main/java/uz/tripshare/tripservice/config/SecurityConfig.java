package uz.tripshare.tripservice.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.tripshare.tripservice.filter.CustomFilter;


@Configuration
public class SecurityConfig {

    private final String[] WHITE_LIST = {"/trip/swagger-ui/**", "/trip/v3/api-docs/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->
                                authorizeRequests
                                        .requestMatchers(WHITE_LIST).permitAll()
                                        .requestMatchers("/trip/**").hasRole("ADMIN")
                                        .anyRequest().authenticated()
                )
                .addFilterBefore(new CustomFilter(),
                        UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
