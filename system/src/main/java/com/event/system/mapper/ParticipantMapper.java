package com.event.system.mapper;

import com.event.system.dtos.response.ParticipantResponseDto;
import com.event.system.models.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParticipantMapper {
    ParticipantMapper INSTANCE = Mappers.getMapper(ParticipantMapper.class);

    ParticipantResponseDto toParticipantResponse(Participant participant);
    Participant toParticipant(ParticipantResponseDto participantResponseDto);
}
