package techmaster.securitywithdatabase.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techmaster.securitywithdatabase.request.LoginRequest;

@RestController
@RequestMapping("auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpSession session) {
        log.info("request: {}", request);

        // Tạo đối tượng xác thực từ request
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );

        // Xác thực đối tượng
        Authentication authentication = authenticationManager.authenticate(token);
        log.info("authentication: {}", authentication);

        // Nếu xác thực thành công (không xảy ra exception) thì lưu đối tượng authentication vào SecurityContextHolder và tạo một session mới để lưu thông tin đăng nhập đó
        SecurityContextHolder.getContext().setAuthentication(authentication);
        session.setAttribute("TECHMASTER_SESSION", authentication.getName());

        return ResponseEntity.ok("Đăng nhập thành công");
    }
}