package techmaster.jwt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techmaster.jwt.request.LoginRequest;
import techmaster.jwt.security.JwtTokenUtil;

@RestController
@RequestMapping("auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Qualifier("userDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        log.info("request: {}", request);

        // Tạo đối tượng xác thực từ request
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );

        // Xác thực đối tượng
        Authentication authentication = authenticationManager.authenticate(token);
        log.info("authentication: {}", authentication);

        // Nếu xác thực thành công thì:
        // 1. Lưu đối tượng authentication vào SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 2. Tìm kiếm userDetails bằng username, dùng userDetails để tạo ra token để trả về cho client
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String tokenJwt = jwtTokenUtil.generateToken(userDetails);

        // Trả về token
        return ResponseEntity.ok(tokenJwt);
    }
}