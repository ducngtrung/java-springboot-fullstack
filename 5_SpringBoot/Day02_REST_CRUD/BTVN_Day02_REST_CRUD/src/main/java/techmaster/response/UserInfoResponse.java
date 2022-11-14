package techmaster.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
// Chứa thông tin user trả về khi login thành công
public class UserInfoResponse {
    private int id;
    private String email;
}