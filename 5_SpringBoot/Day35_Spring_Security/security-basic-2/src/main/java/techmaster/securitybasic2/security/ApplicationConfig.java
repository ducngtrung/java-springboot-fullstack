package techmaster.securitybasic2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfig {
    // 1. Tạo danh sách user (List<UserDetails>)
    private final List<UserDetails> userDetailsList = new ArrayList<>(List.of(
            new User("user1", "$2a$10$QhxPzaU0VyfMYEiAxwmuUOMejsZyT4OjhviJuQYx.Pmm4Q4vgU/Wa",
                    // Phía trên là chuỗi password đã được mã hóa bằng passwordEncoder (xem phương thức test_encode trong SecurityBasic2ApplicationTests.java)
                    List.of(new SimpleGrantedAuthority("ROLE_USER"))),
            new User("user2", "$2a$10$QhxPzaU0VyfMYEiAxwmuUOMejsZyT4OjhviJuQYx.Pmm4Q4vgU/Wa",
                    List.of(new SimpleGrantedAuthority("ROLE_USER"),
                            new SimpleGrantedAuthority("ROLE_ADMIN")))
    ));

    // 2. Tạo đối tượng mã hóa mật khẩu (PasswordEncoder)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 3. Tạo đối tượng UserDetailsService để tìm kiếm user
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                // tìm kiếm từ danh sách userDetailsList đối tượng có username trùng với tham số truyền vào
                return userDetailsList.stream()
                        .filter(userDetails -> userDetails.getUsername().equals(username))
                        .findFirst()
                        .orElseThrow(() -> {
                            throw new UsernameNotFoundException("Not found user with username = " + username);
                        });
            }
        };
    }

    // 4. Tạo AuthenticationProvider để kết hợp PasswordEncoder với UserDetailsService
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}