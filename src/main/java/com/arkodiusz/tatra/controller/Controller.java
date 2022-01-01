package com.arkodiusz.tatra.controller;

import com.arkodiusz.tatra.domain.PeekDto;
import com.arkodiusz.tatra.mapper.PeekMapper;
import com.arkodiusz.tatra.service.PeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final PeekService service;
    private final PeekMapper mapper;

    @GetMapping(value = "/peeks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PeekDto fetchPeek(@PathVariable Long id) {
        return mapper.mapToPeekDto(
                service.fetchPeek(id)
        );
    }

    @GetMapping(value = "/peeks")
    @ResponseStatus(HttpStatus.OK)
    public List<PeekDto> fetchAllPeeks() {
        return mapper.mapToPeekDtoList(
                service.fetchAllPeeks()
        );
    }

    @PostMapping(value = "/peeks", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public PeekDto createPeek(@RequestBody PeekDto peekDto) {
        return mapper.mapToPeekDto(
                service.createOrUpdatePeek(mapper.mapToPeek(peekDto))
        );
    }

    @PutMapping(value = "/peeks", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public PeekDto updatePeek(@RequestBody PeekDto peekDto) {
        return mapper.mapToPeekDto(
                service.createOrUpdatePeek(mapper.mapToPeek(peekDto))
        );
    }

    @DeleteMapping(value = "/peeks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePeek(@PathVariable Long id) {
        service.deletePeek(id);
    }
}
