package org.itis.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
    private Integer id;
    private String title;
    private String startDate;
    private String finishDate;
}
