package techmaster.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
// Chứa thông tin error trả về
public class ErrorResponse {
    private HttpStatus status;
    private Object message;
}