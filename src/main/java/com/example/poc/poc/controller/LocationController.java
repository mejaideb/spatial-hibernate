package com.example.poc.poc.controller;

import com.example.poc.poc.entity.Address;
import com.example.poc.poc.service.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private Location locationService;

    @GetMapping("/getAddresses")
    public List<Address> retrieveAllAddresses() {
        return locationService.findAll();
    }
//
    @PostMapping("")
    public Address saveAll(@RequestBody Address address) {
        return locationService.save(address);
    }

    @GetMapping("/getAddressesBy")
    public List<Address> searchByLocation(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double radius){
        return locationService.searchByLocation(latitude,longitude,radius);
    }
}
