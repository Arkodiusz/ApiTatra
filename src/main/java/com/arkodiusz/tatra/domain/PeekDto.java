package com.arkodiusz.tatra.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class PeekDto {
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private double elevation;
    private double gpsElevation;
    private String imageUrl;
    private String description;
}
