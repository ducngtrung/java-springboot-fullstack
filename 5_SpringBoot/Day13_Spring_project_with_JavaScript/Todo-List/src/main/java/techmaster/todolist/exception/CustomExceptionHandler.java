package techmaster.todolist.exception;

import techmaster.todolist.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
// Khi chạy ứng dụng, nếu ở bất cứ layer nào xảy ra lỗi (exception) thì ứng dụng sẽ truy cập vào đây để xử lý exception tương ứng và trả về response cho client mà không cần thông qua các layer khác
public class CustomExceptionHandler {

    // Xử lý not found
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    // Xử lý các exception khác
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleOtherExceptions(Exception exception) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}
