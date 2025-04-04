package com.event.system.v2;

import com.event.system.dtos.response.ParticipantResponseDto;
import com.event.system.mapper.ParticipantMapper;
import com.event.system.v2.address.Address;
import com.event.system.models.Participant;
import com.event.system.v2.address.AddressService;
import com.event.system.services.ParticipantService;
import com.event.system.v2.exceptions.EventNotFoundException;
import com.event.system.v2.exceptions.ParticipantNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
public class EventServiceV2 {

    private final ParticipantService participantService;
    private final EventV2Repository eventV2Repository;
    private final EventMapperV2 eventMapper;
    private final ParticipantMapper participantMapper;
    private final AddressService addressService;

    public EventServiceV2(ParticipantService participantService, EventV2Repository eventV2Repository, EventMapperV2 eventMapper, ParticipantMapper participantMapper, AddressService addressService) {
        this.participantService = participantService;
        this.eventV2Repository = eventV2Repository;
        this.eventMapper = eventMapper;
        this.participantMapper = participantMapper;
        this.addressService = addressService;
    }

    public EventResponseDtoV2 addEventV2(EventRequestDtoV2 eventRequestDto) {
        Address eventAddress = addressService.getAddress(eventRequestDto.getCep());
        eventAddress.setUnit(eventRequestDto.getNumero());
        eventAddress.setComplement(eventRequestDto.getComplemento());

        EventV2 event = new EventV2(eventRequestDto.getName(), eventRequestDto.getDate(), eventAddress);
        eventV2Repository.save(event);
        return eventMapper.toEventResponse(event);
    }

    public EventResponseDtoV2 getEventByName(String name) {
        EventV2 eventV2 = eventV2Repository.getByName(name);
        return eventMapper.toEventResponse(eventV2);
    }

    public EventResponseDtoV2 getEventById(Long eventId){
        try {
            EventV2 event = eventV2Repository.getById(eventId);
            return eventMapper.toEventResponse(event);
        }catch (RuntimeException e){
            throw new EventNotFoundException(e.getMessage());
        }
    }

    public void addParticipantToEvent(Long id, String name) {
        EventV2 event = eventV2Repository.getByName(name);
        Participant participant = participantService.getParticipant(id);

        if (event.getParticipants().contains(participant)) {
            throw new ParticipantNotFoundException("Participant " + name + " is already in this event\n");
        } else {
            event.getParticipants().add(participant);
            eventV2Repository.save(event);
            System.out.printf("Participant " + name + " add with success \n");
        }
    }

    public void removeParticipantFromEvent(Long participantId, String eventName) {
        EventV2 event = eventV2Repository.getByName(eventName);
        Participant participant = participantService.getParticipant(participantId);

        if (event.getParticipants().contains(participant)) {
            event.getParticipants().remove(participant);
            eventV2Repository.save(event);
        } else {
            throw new ParticipantNotFoundException("Participant with id " + participant.getId() + " is not in this event\n");
        }
    }

    public EventResponseDtoV2 updateEvent(Long id, EventRequestDtoV2 eventRequestDto) {
        Address eventAddress = addressService.getAddress(eventRequestDto.getCep());
        eventAddress.setUnit(eventRequestDto.getNumero());
        eventAddress.setComplement(eventRequestDto.getComplemento());

        EventV2 event = eventV2Repository.getById(id);
        event.setName(eventRequestDto.getName());
        event.setDate(eventRequestDto.getDate());
        event.setLocal(eventAddress);

        eventV2Repository.save(event);
        return eventMapper.toEventResponse(event);
    }

    public Set<ParticipantResponseDto> getAllParticipantsToEvent(Long eventId) {
        EventV2 event = eventV2Repository.getById(eventId);
        EventResponseDtoV2 eventResponseDto = eventMapper.toEventResponse(event);
        if (event.getParticipants() == null || event.getParticipants().isEmpty()) {
            throw new ParticipantNotFoundException("Event don't have any participants");
        }
        return eventResponseDto.getParticipants();
    }

    public List<EventResponseDtoV2> listAllEventsForDate() {
        List<EventV2> events = eventV2Repository.findAll();

        if (events.isEmpty()){
            throw new EventNotFoundException("Don't have any events");
        }

        List<EventV2> sortedEvents = events.stream()
                .sorted(Comparator.comparing(EventV2::getDate))
                .toList();

        List<EventResponseDtoV2> eventResponseDtoList = sortedEvents.stream().
                map(eventMapper::toEventResponse)
                .toList();

        return eventResponseDtoList;
    }

    public void deleteEvent(Long eventId) {
        EventV2 event = eventV2Repository.getById(eventId);
        eventV2Repository.delete(event);
    }

    public List<EventResponseDtoV2> getEventsWithAtLeastXParticipants(int numberOfParticipants) {
        List<EventV2> events = eventV2Repository.findAll();

        List<EventV2> filteredEvents = events.stream()
                .filter(event -> event.getParticipants() != null && event.getParticipants().size() >= numberOfParticipants)
                .toList();

        return filteredEvents.stream()
                .map(eventMapper::toEventResponse)
                .toList();
    }

    public EventResponseDtoV2 listParticipantsByAge(Long eventId) {

        EventV2 event = eventV2Repository.getById(eventId);
        EventResponseDtoV2 eventResponseDto = eventMapper.toEventResponse(event);

        List<ParticipantResponseDto> participants = eventResponseDto.getParticipants().stream()
                .filter(participant -> event.getParticipants() != null && !event.getParticipants().isEmpty())
                .sorted(Comparator.comparing(ParticipantResponseDto::getAge))
                .toList();

        eventResponseDto.setParticipants((Set<ParticipantResponseDto>) participants);

        return eventResponseDto;
    }
}
