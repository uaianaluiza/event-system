package com.event.system.services;

import com.event.system.dtos.request.ParticipantRequestDto;
import com.event.system.dtos.response.ParticipantResponseDto;
import com.event.system.mapper.ParticipantMapper;
import com.event.system.models.Participant;
import com.event.system.repositorys.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final ParticipantMapper participantMapper;

    public ParticipantService(ParticipantRepository participantRepository, ParticipantMapper participantMapper) {
        this.participantRepository = participantRepository;
        this.participantMapper = participantMapper;
    }

    public ParticipantResponseDto addParticipant(ParticipantRequestDto participantRequestDto) {

        Participant participant = new Participant(
                participantRequestDto.getName(),
                participantRequestDto.getEmail(),
                participantRequestDto.getAge()
        );

        Participant savedParticipant = participantRepository.save(participant);

        return participantMapper.toParticipantResponse(savedParticipant);
    }

    public ParticipantResponseDto getParticipantResponse(long id) {
        Participant participant = participantRepository.getById(id);
        return participantMapper.toParticipantResponse(participant);
    }

    public Participant getParticipant(long id) {
        return participantRepository.getById(id);
    }



    public List<ParticipantResponseDto> getAllParticipants() {
        List<Participant> participants = participantRepository.findAll();

        return participants.stream()
                .map(participantMapper::toParticipantResponse)
                .toList();
    }

}
