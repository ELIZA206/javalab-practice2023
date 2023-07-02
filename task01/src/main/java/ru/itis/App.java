package ru.itis;

import ru.itis.repositories.EventsRepository;
import ru.itis.repositories.EventsRepositoryFileImpl;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryFileImpl;
import ru.itis.services.AppService;

import java.io.FileNotFoundException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        UsersRepository usersRepository = new UsersRepositoryFileImpl("users.txt");
        EventsRepository eventsRepository =new EventsRepositoryFileImpl("events.txt","events_users.txt");
        AppService appService =new AppService(usersRepository,eventsRepository);
  //      appService.signUp("admin@gmail.com", "qwerty007");
  //      appService.signUp("marsel.gmail.com", "qwerty008");
  //      appService.addEvent("Практика по Java", LocalDate.now());
  //      appService.addEvent("Практика по Golang", LocalDate.now().plusDays(1));
   //     appService.addUserToEvent("marsel@gmail.com", "Практика по Golang");
   //     appService.addUserToEvent("marsel@gmail.com", "Практика по Java");
        appService.getAllEventsByUser("marsel@gmail.com");



    }
}
