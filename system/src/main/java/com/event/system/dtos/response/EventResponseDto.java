package com.event.system.dtos.response;

import com.event.system.models.Participant;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@Getter
public class EventResponseDto {

    private Long id;
    private String name;
    private LocalDate date;
    private String local;
    private Set<ParticipantResponseDto> participants;
}
