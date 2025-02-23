package com.event.system.controllers;

import com.event.system.dtos.request.ParticipantRequestDto;
import com.event.system.dtos.response.ParticipantResponseDto;
import com.event.system.models.Participant;
import com.event.system.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipantResponseDto addParticipant(@RequestBody ParticipantRequestDto participantRequestDto) {
        return participantService.addParticipant(participantRequestDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Participant getParticipant(@PathVariable int id) {
        return participantService.getParticipant(id);
    }
}
