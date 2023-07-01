package ru.itis.repositories;
// Create, Read, Update, Delete
public interface CrudRepository<T> {
    void save(T model);

}
