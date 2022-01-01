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

    public Peek fetchPeek(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Peek with id " + id + " not found"));
    }

    public List<Peek> fetchAllPeeks() {
        return repository.findAll();
    }

    public Peek createOrUpdatePeek(Peek peek) {
        return repository.save(peek);
    }

    public void deletePeek(Long id) {
        repository.deleteById(id);
    }

}
