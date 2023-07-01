package ru.itis.repositories;

import ru.itis.models.Event;
import ru.itis.models.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class EventsRepositoryFileImpl implements EventsRepository {
    private final String eventFileName;
    private final String eventsAndUsersFileName;

    public EventsRepositoryFileImpl(String eventFileName, String eventsAndUsersFileName) {
        this.eventFileName = eventFileName;
        this.eventsAndUsersFileName = eventsAndUsersFileName;
    }


    @Override
    public void save(Event model) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(eventFileName, true))){
            writer.write(model.getId() + "|" + model.getName() + "|" +  model.getDate());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
    @Override
    public Event findByName(String nameEvent) {
        if (nameEvent.equals("Практика по Golang")) {
            return Event.builder()
                    .id("c5bcc553-a8f3-4619-8e34-c19abf75aab5")
                    .name("Практика по Golang")
                    .date(LocalDate.parse("2023-07-01"))
                    .build();
        }
        return null;
    }

    @Override
    public void saveUserToEvent(User user, Event event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(eventsAndUsersFileName, true))){
            writer.write(user.getId() + "|" + event.getId());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }


    }


    }
