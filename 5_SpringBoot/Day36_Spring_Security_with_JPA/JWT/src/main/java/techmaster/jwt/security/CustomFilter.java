// Tạo CustomFilter để kiểm tra mỗi request gửi lên. Filter này được sử dụng trong SecurityConfig.

package techmaster.jwt.security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// Thêm annotation @Component để tạo ra Bean
@Component
@Slf4j
public class CustomFilter extends OncePerRequestFilter {

    @Qualifier("userDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // Lấy token từ header
        String authorizationToken = request.getHeader("Authorization");
        // Nếu token không hợp lệ (null hoặc không bắt đầu bằng "Bearer") thì dừng lại
        if (authorizationToken == null || !authorizationToken.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }
        // Bỏ 7 ký tự đầu tiên của authorizationToken để lấy ra token (vì authorizationToken có dạng: Bearer <token>)
        String token = authorizationToken.substring(7);
        log.info("token: {}", token);

        // Lấy thông tin username (email) từ token
        // Claims chính là payload chứa nội dung chính của token
        Claims claims = jwtTokenUtil.getClaimsFromToken(token);
        String username = claims.getSubject(); // dùng getter getSubject() để lấy ra email, vì khi generate token đã set email của user làm subject cho token
        log.info("email: {}", username);

        // Kiểm tra username
        if (username == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // Lấy thông tin user theo username bên trên
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        log.info("role: {}", userDetails.getAuthorities());

        // Tạo đối tượng xác thực
        // Phương thức .getAuthorities() lấy ra danh sách quyền của user
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        // Nếu xác thực thành công thì lưu đối tượng xác thực vào SecurityContextHolder rồi chuyển qua bộ lọc tiếp theo
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}