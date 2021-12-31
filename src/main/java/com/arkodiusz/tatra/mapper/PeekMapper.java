package com.arkodiusz.tatra.mapper;

import com.arkodiusz.tatra.domain.Peek;
import com.arkodiusz.tatra.domain.PeekDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeekMapper {

    public Peek mapToPeek(final PeekDto peekDto) {
        return new Peek(
                peekDto.getId(),
                peekDto.getName(),
                peekDto.getLatitude(),
                peekDto.getLongitude(),
                peekDto.getElevation(),
                peekDto.getGpsElevation(),
                (peekDto.getImageUrl()!= null) ? peekDto.getImageUrl() : "",
                (peekDto.getDescription()!= null) ? peekDto.getDescription() : ""
        );
    }

    public PeekDto mapToPeekDto(final Peek peek) {
        return new PeekDto(
                peek.getId(),
                peek.getName(),
                peek.getLatitude(),
                peek.getLongitude(),
                peek.getElevation(),
                peek.getGpsElevation(),
                peek.getImageUrl(),
                peek.getDescription()
        );
    }

    public List<PeekDto> mapToPeekDtoList(final List<Peek> peekList) {
        return peekList.stream()
                .map(this::mapToPeekDto)
                .collect(Collectors.toList());
    }

}
