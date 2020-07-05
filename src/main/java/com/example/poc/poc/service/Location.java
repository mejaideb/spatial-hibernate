package com.example.poc.poc.service;

import com.example.poc.poc.entity.Address;
import com.example.poc.poc.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Location {

    @Autowired
    LocationRepository locationRepository;

    private static List<Address> addresses = new ArrayList<>();
    private long addressCount = 5;


    public List<Address> findAll(){
        return (List<Address>) locationRepository.findAll();
    }

    @Transactional
    public Address save(Address address) {
        if (Objects.nonNull(address.getId()))
            address.setId(++addressCount);
        locationRepository.save(address);
        if (Objects.nonNull(address.getLatitude()) && Objects.nonNull(address.getLongitude())) {
            locationRepository.saveGeolocation(address.getLongitude(), address.getLatitude(), addressCount);

        }
        return address;
    }

    public List<Address> searchByLocation(double latitude, double longitude, double radius) {
        return locationRepository.searchByLocation(latitude, longitude, radius);
    }
}
