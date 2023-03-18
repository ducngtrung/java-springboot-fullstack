package BTVN_Day01.jobpost.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Job {
    private String id;
    private String title;
    private String location;
    private int minSalary;
    private int maxSalary;
}