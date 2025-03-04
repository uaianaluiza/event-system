package com.event.system.controllers;

import com.event.system.dtos.request.EventRequestDto;
import com.event.system.dtos.response.EventResponseDto;
import com.event.system.dtos.response.ParticipantResponseDto;
import com.event.system.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/events")
public class EventsController {

    private final EventService eventService;

    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

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

    @GetMapping("/{eventName}")
    @ResponseStatus(HttpStatus.OK)
    public EventResponseDto getEventByName(@PathVariable String eventName) {
        return eventService.getEventByName(eventName);
    }

    @GetMapping("/allParticipantsToEvent/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public Set<ParticipantResponseDto> getParticipantsToEvent(@PathVariable Long eventId) {
        return eventService.getAllParticipantsToEvent(eventId);
    }

    @GetMapping("/report/moreThanParticipants/{numberOfParticipants}")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponseDto> getEventsWithAtLeastXParticipants(@PathVariable int numberOfParticipants) {
        return eventService.getEventsWithAtLeastXParticipants(numberOfParticipants);
    }

    @GetMapping("/report/listParticipantsByAge/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public EventResponseDto listParticipantsByAge(@PathVariable Long eventId) {
        return eventService.listParticipantsByAge(eventId);
    }

    @PutMapping("/update/{eventId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EventResponseDto updateEvent(@PathVariable Long eventId, @RequestBody EventRequestDto eventRequestDto) {
        return eventService.updateEvent(eventId, eventRequestDto);
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

    @DeleteMapping("/deleteEvent/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
    }

}
