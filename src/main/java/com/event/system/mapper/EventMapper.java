package com.event.system.mapper;

import com.event.system.dtos.response.EventResponseDto;
import com.event.system.models.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = ParticipantMapper.class)
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(target = "participants", source = "participants")
    EventResponseDto toEventResponse (Event event);

}
