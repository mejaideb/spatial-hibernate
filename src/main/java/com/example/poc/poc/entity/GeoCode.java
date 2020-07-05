package com.example.poc.poc.entity;

import lombok.AllArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
public class GeoCode {
    private double latitude;
    private double longitude;
}
