package ru.itis.repositories;

import ru.itis.models.Event;
import ru.itis.models.User;

public interface EventsRepository extends CrudRepository<Event> {
    void saveUserToEvent(User user, Event event);

    Event findByName(String nameEvent);
}
