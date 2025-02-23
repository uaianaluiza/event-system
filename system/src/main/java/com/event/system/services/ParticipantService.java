package com.event.system.services;

import com.event.system.dtos.request.ParticipantRequestDto;
import com.event.system.dtos.response.ParticipantResponseDto;
import com.event.system.mapper.ParticipantMapper;
import com.event.system.models.Participant;
import com.event.system.repositorys.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

    private ParticipantRepository participantRepository;
    private ParticipantMapper participantMapper;


    public ParticipantResponseDto addParticipant(ParticipantRequestDto participantRequestDto) {

        Participant participant = new Participant(
                participantRequestDto.getName(),
                participantRequestDto.getEmail(),
                participantRequestDto.getAge()
        );

        Participant savedParticipant = participantRepository.save(participant);

        return participantMapper.toParticipantResponse(savedParticipant);
    }

    public Participant getParticipant(long id) {
        return participantRepository.findById(id).orElse(null);
    }

}
