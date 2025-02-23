package com.event.system.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class EventRequestDto {
    private String name;
    private LocalDate date;
    private String local;

}
