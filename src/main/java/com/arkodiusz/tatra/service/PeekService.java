package com.arkodiusz.tatra.service;

import com.arkodiusz.tatra.domain.Peek;
import com.arkodiusz.tatra.repository.PeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeekService {

    private final PeekRepository repository;

    public List<Peek> fetchAllPeeks() {
        return repository.findAll();
    }

    public Peek createPeek(Peek peek) {
        return repository.save(peek);
    }

}
