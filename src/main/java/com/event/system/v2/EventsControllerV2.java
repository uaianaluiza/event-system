package com.event.system.v2;

import com.event.system.dtos.response.ParticipantResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/events/v2")
public class EventsControllerV2 {


    private final EventServiceV2 eventService;

    public EventsControllerV2(EventServiceV2 eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponseDtoV2 addEvent(@RequestBody EventRequestDtoV2 eventRequestDto) {
        return eventService.addEventV2(eventRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponseDtoV2> getEvents() {
        return eventService.listAllEventsForDate();
    }

    @GetMapping("/{eventName}")
    @ResponseStatus(HttpStatus.OK)
    public EventResponseDtoV2 getEventByName(@PathVariable String eventName) {
        return eventService.getEventByName(eventName);
    }

    @GetMapping("/id/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public EventResponseDtoV2 getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId);
    }

    @GetMapping("/allParticipantsToEvent/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public Set<ParticipantResponseDto> getParticipantsToEvent(@PathVariable Long eventId) {
        return eventService.getAllParticipantsToEvent(eventId);
    }

    @GetMapping("/report/moreThanParticipants/{numberOfParticipants}")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponseDtoV2> getEventsWithAtLeastXParticipants(@PathVariable int numberOfParticipants) {
        return eventService.getEventsWithAtLeastXParticipants(numberOfParticipants);
    }

    @GetMapping("/report/listParticipantsByAge/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public EventResponseDtoV2 listParticipantsByAge(@PathVariable Long eventId) {
        return eventService.listParticipantsByAge(eventId);
    }

    @PutMapping("/update/{eventId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EventResponseDtoV2 updateEvent(@PathVariable Long eventId, @RequestBody EventRequestDtoV2 eventRequestDto) {
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
