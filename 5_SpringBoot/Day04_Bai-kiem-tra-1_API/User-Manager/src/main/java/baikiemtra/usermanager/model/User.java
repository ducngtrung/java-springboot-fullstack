package baikiemtra.usermanager.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String avatar; // link ảnh đại diện
    private String password;
}