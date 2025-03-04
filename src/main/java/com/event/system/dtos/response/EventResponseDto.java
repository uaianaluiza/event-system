package com.event.system.dtos.response;

import java.time.LocalDate;
import java.util.Set;

public class EventResponseDto {

    private Long id;
    private String name;
    private LocalDate date;
    private String local;
    private Set<ParticipantResponseDto> participants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Set<ParticipantResponseDto> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<ParticipantResponseDto> participants) {
        this.participants = participants;
    }
}
