package com.arkodiusz.tatra.controller;

import com.arkodiusz.tatra.domain.PeekDto;
import com.arkodiusz.tatra.mapper.PeekMapper;
import com.arkodiusz.tatra.service.PeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final PeekService service;
    private final PeekMapper mapper;

    @GetMapping(value = "/peeks")
    public List<PeekDto> fetchAllPeeks() {
        return mapper.mapToPeekDtoList(
                service.fetchAllPeeks()
        );
    }

    @PostMapping(value = "/peeks", consumes = APPLICATION_JSON_VALUE)
    public PeekDto createPeek(@RequestBody PeekDto peekDto) {
        return mapper.mapToPeekDto(
                service.createPeek(mapper.mapToPeek(peekDto))
        );
    }
}
