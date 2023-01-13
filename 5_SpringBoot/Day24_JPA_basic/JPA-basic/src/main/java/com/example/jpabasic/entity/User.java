package com.example.jpabasic.entity;

import com.example.jpabasic.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

// Định nghĩa trước một số query trong entity để dùng chúng trong repository
// JPQL
@NamedQueries({
        @NamedQuery(name = "User.findByAge", query = "select u from User u where u.age = :age")
})
// Native Query
@NamedNativeQuery(
        name = "findAllUserDto",
        resultSetMapping = "listUserDto",
        query = "select id, name, email from user")
@SqlResultSetMappings(value = {
        @SqlResultSetMapping(
                name = "listUserDto",
                classes = @ConstructorResult(
                        targetClass = UserDto.class,
                        // Đưa từng colum vào theo thứ tự trong constructor của UserDto
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "email", type = String.class)
                        }
                )
        )
})

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id // primary key
    @GeneratedValue // tự động tạo id bằng sequence
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "age")
    private Integer age;
}