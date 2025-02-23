package com.event.system.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, name = "name")
    private String name;

    @Setter
    @Column(nullable = false, name = "date")
    private LocalDate date;

    @Setter
    @Column(nullable = false, name = "local")
    private String local;

    @OneToMany
    @Column(nullable = false, name = "participants" )
    private Set<Participant> participants;

    public Event(String name, LocalDate date, String local) {
        this.name = name;
        this.date = date;
        this.local = local;
    }

    public Event() {
    }
}
