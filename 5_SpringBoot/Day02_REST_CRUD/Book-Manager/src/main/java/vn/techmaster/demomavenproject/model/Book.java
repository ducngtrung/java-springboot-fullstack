package vn.techmaster.demomavenproject.model;
// model là nơi định nghĩa các class của project

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    private int id;
    private String title;
    private int publishYear;
}
