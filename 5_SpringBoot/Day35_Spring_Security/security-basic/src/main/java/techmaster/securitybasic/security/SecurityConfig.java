// Config username và password trong file application.properties
// 401: Unauthorized là lỗi do chưa đăng nhập
// 403: Forbidden là lỗi do chưa đúng quyền truy cập (VD: đã đăng nhập role USER nhưng lại truy cập vào đường dẫn cần role ADMIN)

package techmaster.securitybasic.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                // dùng and() để nối nhiều câu lệnh http riêng rẽ thành 1 câu lệnh
            .and()
                .csrf().disable()
            .authorizeHttpRequests()
                // không yêu cầu đăng nhập đối với đường dẫn này (cho phép tất cả người dùng truy cập)
            .requestMatchers("/", "/auth/**").permitAll()
                // yêu cầu người dùng phải có role admin mới truy cập được đường dẫn này
            .requestMatchers("/admin/**").hasRole("ADMIN")
                // cho phép nhiều role truy cập đường dẫn này
            .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()
            .and()
                .formLogin()
            .and()
                .httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsServiceTest() {
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("user1")
                .password("111")
                .roles("USER")
                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("user2")
                .password("111")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(List.of(user1, user2));
    }
}