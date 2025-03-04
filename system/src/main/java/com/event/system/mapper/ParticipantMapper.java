package com.event.system.mapper;

import com.event.system.dtos.response.ParticipantResponseDto;
import com.event.system.models.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {
    ParticipantMapper INSTANCE = Mappers.getMapper(ParticipantMapper.class);

    ParticipantResponseDto toParticipantResponse(Participant participant);
    Participant toParticipant(ParticipantResponseDto participantResponseDto);
    Set<ParticipantResponseDto> toParticipantResponseSet(Set<Participant> participant);
}
