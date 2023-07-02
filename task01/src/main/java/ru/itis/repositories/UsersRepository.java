package ru.itis.repositories;

import ru.itis.models.User;

import java.io.FileNotFoundException;

public interface UsersRepository extends CrudRepository<User>{

    User findByEmail(String emailUser) throws FileNotFoundException;
}
