package com.event.system.mapper;

import com.event.system.dtos.response.EventResponseDto;
import com.event.system.models.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventResponseDto toEventResponse (Event event);
    Event toEvent (EventResponseDto responseDto);

}
