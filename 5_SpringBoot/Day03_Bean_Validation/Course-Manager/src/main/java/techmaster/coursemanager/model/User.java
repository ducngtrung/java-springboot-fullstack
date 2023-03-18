package techmaster.coursemanager.model;

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
    private String avatar; // Ảnh đại diện
}