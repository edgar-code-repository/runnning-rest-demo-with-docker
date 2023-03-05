package com.example.demo.controller;

import com.example.demo.dto.CountryListResponseDTO;
import com.example.demo.dto.CountryResponseDTO;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<CountryListResponseDTO> getAllCountries() {
        CountryListResponseDTO countryListResponseDTO = CountryListResponseDTO.builder()
                .message("List retrieved!!!")
                .countryList(countryService.getAllCountries())
                .build();
        return ResponseEntity.ok().body(countryListResponseDTO);
    }

    @GetMapping("/countries/{countryId}")
    public ResponseEntity<CountryResponseDTO> getCountryById(@PathVariable int countryId) {
        CountryResponseDTO countryResponseDTO = CountryResponseDTO.builder()
                .message("Country retrieved!!!")
                .country(countryService.getCountryById(countryId))
                .build();
        return ResponseEntity.ok().body(countryResponseDTO);
    }

}
