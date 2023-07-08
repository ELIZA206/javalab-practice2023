package org.itis.repositories.impl;

import org.itis.models.Course;
import org.itis.repositories.CoursesRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CoursesRepositoryJdbcImpl implements CoursesRepository {

    private final static String SQL_SELECT_ALL = "select * from course";
    private final DataSource dataSource;

    public CoursesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void save(Course model) {

    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            try (ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL)) {
                while (resultSet.next()) {
                    Course course = Course.builder()
                            .id(resultSet.getInt("id"))
                            .title(resultSet.getString("title"))
                            .startDate(resultSet.getString("start_date"))
                            .finishDate(resultSet.getString("finish_date"))

                            .build();
                    courses.add(course);
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return courses;
    }
    }
