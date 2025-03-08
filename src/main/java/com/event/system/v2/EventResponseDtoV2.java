package com.event.system.v2;

import com.event.system.dtos.response.ParticipantResponseDto;
import com.event.system.v2.address.Address;
import com.event.system.v2.address.AddressResponseDto;

import java.time.LocalDate;
import java.util.Set;

public class EventResponseDtoV2 {

    private Long id;
    private String name;
    private LocalDate date;
    private AddressResponseDto local;
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

    public AddressResponseDto getLocal() {
        return local;
    }

    public void setLocal(AddressResponseDto local) {
        this.local = local;
    }

    public Set<ParticipantResponseDto> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<ParticipantResponseDto> participants) {
        this.participants = participants;
    }
}
