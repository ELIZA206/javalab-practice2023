package ru.itis.repositories;

import ru.itis.models.Event;
import ru.itis.models.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(eventFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        for (String line : lines) {
            String[] inf = line.split("\\|");
            if (nameEvent.equals(inf[1])) {
                return Event.builder()
                        .id(inf[0])
                        .name(inf[1])
                        .date(LocalDate.parse(inf[2]))
                        .build();
            }

        }
        return null;
    }

    @Override
    public List<Event> findAllByMembersContains(User user) {
        List<Event> event = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        List<String> ID = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(eventsAndUsersFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        for (String line : lines) {
            String[] inf = line.split("\\|");
            if (user.getId().equals(inf[0])) {
                ID.add(inf[1]);
            }
        }
        List<String> lines0 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(eventFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines0.add(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        for (String line : lines0) {
            String[] inf = line.split("\\|");
            for (String id : ID) {
                if (id.equals(inf[0])) {
                    event.add(Event.builder()
                            .id(inf[0])
                            .name(inf[1])
                            .date(LocalDate.parse(inf[2]))
                            .build());
                }
            }
        }
        return event;
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
