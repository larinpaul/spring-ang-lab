package com.example.developer.springanglab;

import com.example.developer.springanglab.model.Event;
import com.example.developer.springanglab.model.Group;
import com.example.developer.springanglab.model.GroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Omaga JUG", "Kanzas cITY jug", "Chicago JUG",
                "Dallas JUG", "Philly JUG", "Garden State JUG", "NY Java SIG")
                .forEach(name -> repository.save(new Group(name)));

        Group jug = repository.findByName("Garden State JUG");
        Event e = new Event(Instant.parse("2023-10-18T18:00:00.000Z"),
                "OAuth for Java Developers", "Learn all about OAuth and OIDC + Java!");
        jug.setEvents(Collections.singleton(e));
        repository.save(jug);

        repository.findAll().forEach(System.out::println);

    }
}
