// Tạo CustomFilter để kiểm tra mỗi request gửi lên. Filter này được sử dụng trong SecurityConfig.

package techmaster.securitybasic2.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
public class CustomFilter extends OncePerRequestFilter {

    @Qualifier("userDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // Lấy username từ session
        String username = (String) request.getSession().getAttribute("TECHMASTER_SESSION");

        // Nếu username = null thì chuyển qua bộ lọc tiếp theo
        if (username == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // Lấy thông tin user theo username bên trên
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // Tạo đối tượng xác thực
        // Phương thức .getAuthorities() lấy ra danh sách quyền của user
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        // Nếu xác thực thành công thì lưu đối tượng xác thực vào SecurityContextHolder rồi chuyển qua bộ lọc tiếp theo
        SecurityContextHolder.getContext().setAuthentication(token);
        filterChain.doFilter(request, response);
    }
}