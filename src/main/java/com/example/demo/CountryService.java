package com.example.demo;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public void saveCountry(Country country) {
        log.info("[saveCountry][country: " + country.getName() + "]");
        countryRepository.save(country);
    }


}
