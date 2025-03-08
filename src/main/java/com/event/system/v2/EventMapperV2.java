package com.event.system.v2;

import com.event.system.mapper.ParticipantMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = ParticipantMapper.class)
public interface EventMapperV2 {
    EventMapperV2 INSTANCE = Mappers.getMapper(EventMapperV2.class);

    @Mapping(target = "participants", source = "participants")
    @Mapping(target = "local", source = "local")
    EventResponseDtoV2 toEventResponse (EventV2 event);
}
