package ru.itis.repositories;

import ru.itis.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersRepositoryFileImpl implements UsersRepository {
    private final String fileName;

    public UsersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void save(User model) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(model.getId() + "|" + model.getEmail() + "|" + model.getPassword());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public User findByEmail(String emailUser) {
        // TODO: необходимо реализовать
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        for (String line : lines) {
            String[] inf = line.split("\\|");
            if (emailUser.equals(inf[1])) {
                return User.builder()
                        .id(inf[0])
                        .email(inf[1])
                        .password(inf[2])
                        .build();
            }

        }
        return null;
    }
}
