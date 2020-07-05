package com.example.poc.poc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Address {

    @Id
    private long id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;

    private double latitude;
    private double longitude;
    @Column(columnDefinition = "GEOGRAPHY(POINT)")
    @JsonIgnore
    private com.vividsolutions.jts.geom.Point location;

    private String state;
    private String zipCode;


}
