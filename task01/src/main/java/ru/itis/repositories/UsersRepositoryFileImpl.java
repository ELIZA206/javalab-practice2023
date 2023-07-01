package ru.itis.repositories;

import ru.itis.models.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UsersRepositoryFileImpl implements UsersRepository{
    private final String fileName;

    public UsersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void save(User model) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(model.getId() + "|" + model.getEmail() + "|" +  model.getPassword());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public User findByEmail(String emailUser) {
        // TODO: необходимо реализовать
        if (emailUser.equals("marsel@gmail.com")) {
            return User.builder()
                    .id("ef6e1fba-50ed-48be-84bd-263f9ceaa971")
                    .email("marsel@gmail.com")
                    .password("qwerty008")
                    .build();
        } return null;
    }
}
