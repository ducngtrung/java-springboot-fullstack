package techmaster.securitywithdatabase.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import techmaster.securitywithdatabase.response.ErrorResponse;

import java.io.IOException;
import java.io.OutputStream;

// Xử lý trường hợp đã đăng nhập nhưng không có quyền truy cập trang
@Component
public class CustomAccessDenied implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Tạo đối tượng ErrorResponse
        ErrorResponse error = new ErrorResponse(HttpStatus.FORBIDDEN.value(), "Bạn không có quyền truy cập trang này");

        // Set thuộc tính (header) cho response
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN); // lỗi 403

        // Convert object -> json
        OutputStream responseStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(responseStream, error);
        responseStream.flush();
    }
}