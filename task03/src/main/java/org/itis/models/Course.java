package org.itis.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
    private Integer id;
    private String title;
    private Date startDate;
    private Date finishDate;
}
