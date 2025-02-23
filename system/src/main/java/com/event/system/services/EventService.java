package com.event.system.services;

import com.event.system.dtos.request.EventRequestDto;
import com.event.system.dtos.response.EventResponseDto;
import com.event.system.dtos.response.ParticipantResponseDto;
import com.event.system.mapper.EventMapper;
import com.event.system.models.Event;
import com.event.system.models.Participant;
import com.event.system.repositorys.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
public class EventService {

    private ParticipantService participantService;
    private EventRepository eventRepository;
    private EventMapper eventMapper;

    public EventResponseDto addEvent(EventRequestDto eventRequestDto) {
        Event event = new Event(eventRequestDto.getName(), eventRequestDto.getDate(),eventRequestDto.getLocal());
        eventRepository.save(event);
        return eventMapper.toEventResponse(event);
    }

    public EventResponseDto getEventByName(String name) {
        Event event =  eventRepository.getByName(name);
        return eventMapper.toEventResponse(event);
    }

    public void addParticipantToEvent(Long id, String name) {
        Event event = eventRepository.getByName(name);
        Participant participant = participantService.getParticipant(id);
        if (event.getParticipants().contains(participant)) {
            System.out.printf("Participant " + name + " is already in this event\n");
        } else {
            event.getParticipants().add(participant);
        }
    }

    public void removeParticipantFromEvent(Long participantId, String eventName) {
        Event event = eventRepository.getByName(eventName);
        Participant participant = participantService.getParticipant(participantId);
        if (event.getParticipants().contains(participant)) {
            event.getParticipants().remove(participant);
        } else {
            System.out.printf("Participant with id " + participant.getId() + " is not in this event\n");
        }
    }

    public EventResponseDto updateEvent(Long id, EventRequestDto eventRequestDto) {
        Event event = eventRepository.getById(id);
        event.setName(eventRequestDto.getName());
        event.setDate(eventRequestDto.getDate());
        event.setLocal(eventRequestDto.getLocal());
        return eventMapper.toEventResponse(event);
    }

    public Set<ParticipantResponseDto> getAllParticipantsToEvent(Long eventId) {
        Event event = eventRepository.getById(eventId);
        EventResponseDto eventResponseDto = eventMapper.toEventResponse(event);
        return eventResponseDto.getParticipants();
    }

    public List<EventResponseDto> listAllEventsForDate() {
        List<Event> events = eventRepository.getAll();

        List<Event> sortedEvents = events.stream()
                .sorted(Comparator.comparing(Event::getDate))
                .toList();

        List<EventResponseDto> eventResponseDtoList = sortedEvents.stream().
                map(eventMapper::toEventResponse)
                .toList();

        return eventResponseDtoList;
    }

    private static Event binarySearchEventByName(List<Event> events, String targetName) {
        int left = 0;
        int right = events.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Event midEvent = events.get(mid);

            int comparison = midEvent.getName().compareTo(targetName);

            if (comparison == 0) {
                return midEvent;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}
