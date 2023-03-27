package techmaster.securitywithdatabase.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomFilter customFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                // dùng and() để nối nhiều câu lệnh http riêng rẽ thành 1 câu lệnh
            .and()
                .csrf().disable()
            .authorizeHttpRequests()
                // không yêu cầu đăng nhập đối với các đường dẫn này (cho phép tất cả người dùng truy cập)
            .requestMatchers("/", "/auth/**").permitAll()
                // yêu cầu người dùng phải có role admin mới truy cập được đường dẫn này
            .requestMatchers("/admin/**").hasRole("ADMIN")
                // cho phép nhiều role truy cập đường dẫn này
            .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()
            .and()
                .authenticationProvider(authenticationProvider)
                // thêm customFilter vào trước UsernamePasswordAuthenticationFilter
                .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}