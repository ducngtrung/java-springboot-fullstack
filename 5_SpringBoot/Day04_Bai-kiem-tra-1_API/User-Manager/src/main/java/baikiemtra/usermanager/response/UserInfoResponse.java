package baikiemtra.usermanager.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInfoResponse {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String avatar;
}