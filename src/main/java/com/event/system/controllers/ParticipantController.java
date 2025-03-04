package com.event.system.controllers;

import com.event.system.dtos.request.ParticipantRequestDto;
import com.event.system.dtos.response.ParticipantResponseDto;
import com.event.system.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ParticipantResponseDto> getAllParticipants() {
        return participantService.getAllParticipants();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ParticipantResponseDto getParticipant(@PathVariable int id) {
        return participantService.getParticipantResponse(id);
    }
}
