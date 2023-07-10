package org.itis;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.itis.models.Course;
import org.itis.models.Student;
import org.itis.repositories.CoursesRepository;
import org.itis.repositories.StudentsRepository;
import org.itis.repositories.impl.CoursesRepositoryJdbcImpl;
import org.itis.repositories.impl.StudentsRepositoryJdbcImpl;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/task03_db");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("1234565");
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        StudentsRepository studentsRepository = new StudentsRepositoryJdbcImpl(dataSource);
        // Student student = Student.builder()
         //       .firstName("Имя1")
         //       .lastName("Фамилия1")
         //       .age(25)
          //      .build();

        //System.out.println(student);
        //studentsRepository.save(student);
        //System.out.println(student);
        //System.out.println(studentsRepository.findAll());
        Course course = Course.builder()
                .title("Math")
                .startDate(Date.valueOf("2025-02-02"))
                .finishDate(Date.valueOf("2070-02-02"))
                .build();
        CoursesRepository coursesRepository = new CoursesRepositoryJdbcImpl(dataSource);
        coursesRepository.save(course);
        System.out.println(coursesRepository.findAll());
    }



}