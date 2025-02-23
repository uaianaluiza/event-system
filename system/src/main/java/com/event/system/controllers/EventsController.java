package com.event.system.controllers;

import com.event.system.dtos.request.EventRequestDto;
import com.event.system.dtos.response.EventResponseDto;
import com.event.system.dtos.response.ParticipantResponseDto;
import com.event.system.models.Event;
import com.event.system.models.Participant;
import com.event.system.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/events")
public class EventsController {

    private EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponseDto addEvent(@RequestBody EventRequestDto eventRequestDto) {
         return eventService.addEvent(eventRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponseDto> getEvents() {
        return eventService.listAllEventsForDate();
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public EventResponseDto getEventByName(@PathVariable String name) {
        return eventService.getEventByName(name);
    }

    @GetMapping("/allParticipantsToEvent/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public Set<ParticipantResponseDto> getParticipantsToEvent(@PathVariable Long eventId) {
        return eventService.getAllParticipantsToEvent(eventId);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EventResponseDto updateEvent(@PathVariable Long id, @RequestBody EventRequestDto eventRequestDto) {
        return eventService.updateEvent(id, eventRequestDto);
    }

    @PutMapping("/addParticipant/{idParticipant}/{eventName}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addParticipante(@PathVariable Long idParticipant, @PathVariable String eventName) {
        eventService.addParticipantToEvent(idParticipant, eventName);
    }

    @PutMapping("/removeParticipant/{idParticipant}/{eventName}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeParticipante(@PathVariable Long idParticipant, @PathVariable String eventName) {
        eventService.removeParticipantFromEvent(idParticipant, eventName);
    }


}
