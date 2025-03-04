package com.event.system.services;

import com.event.system.dtos.request.EventRequestDto;
import com.event.system.dtos.response.EventResponseDto;
import com.event.system.dtos.response.ParticipantResponseDto;
import com.event.system.mapper.EventMapper;
import com.event.system.mapper.ParticipantMapper;
import com.event.system.models.Event;
import com.event.system.models.Participant;
import com.event.system.repositorys.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
public class EventService {

    private final ParticipantService participantService;
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final ParticipantMapper participantMapper;

    public EventService(ParticipantService participantService, EventRepository eventRepository, EventMapper eventMapper, ParticipantMapper participantMapper) {
        this.participantService = participantService;
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.participantMapper = participantMapper;
    }

    public EventResponseDto addEvent(EventRequestDto eventRequestDto) {
        Event event = new Event(eventRequestDto.getName(), eventRequestDto.getDate(), eventRequestDto.getLocal());
        eventRepository.save(event);
        return eventMapper.toEventResponse(event);
    }

    public EventResponseDto getEventByName(String name) {
        Event event = eventRepository.getByName(name);
        return eventMapper.toEventResponse(event);
    }

    public void addParticipantToEvent(Long id, String name) {
        Event event = eventRepository.getByName(name);
        Participant participant = participantService.getParticipant(id);

        if (event.getParticipants().contains(participant)) {
            System.out.printf("Participant " + name + " is already in this event\n");
        } else {
            event.getParticipants().add(participant);
            eventRepository.save(event);
            System.out.printf("Participant " + name + " add with success \n");
        }
    }

    public void removeParticipantFromEvent(Long participantId, String eventName) {
        Event event = eventRepository.getByName(eventName);
        Participant participant = participantService.getParticipant(participantId);

        if (event.getParticipants().contains(participant)) {
            event.getParticipants().remove(participant);
            eventRepository.save(event);
            System.out.printf("Participant " + participant.getName() + " removed with success \n");
        } else {
            System.out.printf("Participant with id " + participant.getId() + " is not in this event\n");
        }
    }

    public EventResponseDto updateEvent(Long id, EventRequestDto eventRequestDto) {
        Event event = eventRepository.getById(id);
        event.setName(eventRequestDto.getName());
        event.setDate(eventRequestDto.getDate());
        event.setLocal(eventRequestDto.getLocal());
        eventRepository.save(event);
        return eventMapper.toEventResponse(event);
    }

    public Set<ParticipantResponseDto> getAllParticipantsToEvent(Long eventId) {
        Event event = eventRepository.getById(eventId);
        EventResponseDto eventResponseDto = eventMapper.toEventResponse(event);
        if (event.getParticipants() == null || event.getParticipants().isEmpty()) {
            System.out.println("Event don't have any participants");
        }
        return eventResponseDto.getParticipants();
    }

    public List<EventResponseDto> listAllEventsForDate() {
        List<Event> events = eventRepository.findAll();

        List<Event> sortedEvents = events.stream()
                .sorted(Comparator.comparing(Event::getDate))
                .toList();

        List<EventResponseDto> eventResponseDtoList = sortedEvents.stream().
                map(eventMapper::toEventResponse)
                .toList();

        return eventResponseDtoList;
    }

    public void deleteEvent(Long eventId) {
        Event event = eventRepository.getById(eventId);
        eventRepository.delete(event);
    }

    public List<EventResponseDto> getEventsWithAtLeastXParticipants(int numberOfParticipants) {
        List<Event> events = eventRepository.findAll();

        List<Event> filteredEvents = events.stream()
                .filter(event -> event.getParticipants() != null && event.getParticipants().size() >= numberOfParticipants)
                .toList();

        return filteredEvents.stream()
                .map(eventMapper::toEventResponse)
                .toList();
    }

    public EventResponseDto listParticipantsByAge(Long eventId) {

        Event event = eventRepository.getById(eventId);
        EventResponseDto eventResponseDto = eventMapper.toEventResponse(event);

        List<ParticipantResponseDto> participants = eventResponseDto.getParticipants().stream()
                .filter(participant -> event.getParticipants() != null && !event.getParticipants().isEmpty())
                .sorted(Comparator.comparing(ParticipantResponseDto::getAge))
                .toList();

        eventResponseDto.setParticipants((Set<ParticipantResponseDto>) participants);

        return eventResponseDto;
    }
}
