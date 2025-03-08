package com.event.system.v2;

import com.event.system.v2.address.Address;
import com.event.system.models.Participant;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "eventsV2")
public class EventV2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "date")
    private LocalDate date;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "event_address",
            joinColumns = @JoinColumn(nullable = false, name = "local"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Address local;

    @ManyToMany
    @JoinTable(
            name = "event_participants",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    private Set<Participant> participants;

    public EventV2(String name, LocalDate date, Address local) {
        this.name = name;
        this.date = date;
        this.local = local;
    }

    public EventV2() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Address getLocal() {
        return local;
    }

    public void setLocal(Address local) {
        this.local = local;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

}
