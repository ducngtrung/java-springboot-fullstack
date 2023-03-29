package techmaster.jwt.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    // Set expiration time cho token là 24 giờ kể từ thời điểm tạo, tính theo giây
    private final Integer duration = 60 * 60 * 24;

    // Tạo 1 key dùng để mã hóa (tạo token) và giải mã (lấy thông tin từ token). Độ dài key > 32 bytes.
    private final String secret = "0d#*)ke8(x&p6ezh1p_2@ob7e3m5#zl!$167s+m$(!m)eid&t8";
    SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

    // Tạo ra token
    // Chạy unit test bằng phương thức generate_token_test() trong JwtApplicationTests.java, sau khi tạo token có thể decode trên trang https://jwt.io/ để đối chiếu thông tin
    public String generateToken(UserDetails userDetails) {
        // Tạo một map để lưu trữ payload của token
        Map<String, Object> claims = new HashMap<>();
        // Lưu thông tin authorities (danh sách quyền) của user vào claims
        claims.put("authorities", userDetails.getAuthorities());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername()) // Lấy email của user làm subject cho token
                .setIssuedAt(new Date(System.currentTimeMillis())) // thời điểm tạo token
                .setExpiration(new Date(System.currentTimeMillis() + duration * 1000)) // thời điểm token expires
                .signWith(key).compact(); // Mã hóa token bằng thuật toán và secret key
    }

    // Lấy thông tin được lưu trong token
    // Chạy unit test bằng phương thức parse_token_test() trong JwtApplicationTests.java (dùng token được tạo bởi generate_token_test() làm tham số đầu vào)
    public Claims getClaimsFromToken(String token) {
        if (token == null) return null;
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}