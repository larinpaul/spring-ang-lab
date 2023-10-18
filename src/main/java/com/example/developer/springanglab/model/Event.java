package com.example.developer.springanglab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.time.Instant;
import java.util.Set;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private Instant date;
    private String title;
    private String description;

    @ManyToMany
    private Set<User> attendees;

    public Event() {
        this.date = date;
        this.title = title;
        this.description = description;
    }

    // you can generate the getters and setters using your IDE!



}
