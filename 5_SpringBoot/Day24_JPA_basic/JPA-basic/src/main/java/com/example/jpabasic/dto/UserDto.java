package com.example.jpabasic.dto;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    private String name;
    private String email;
}