package com.example.demo.component;

import com.example.demo.CountryService;
import com.example.demo.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Scanner;

@Component
@Slf4j
public class CountryRunnerComponent implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    @Override
    public void run(String... args) throws Exception {
        log.info("[run][Running CountryRunnerComponent on startup][START]");
        try {
            log.info("[run][Reading file info-countries-2023-03-03-001.csv]");

            File file = ResourceUtils.getFile("classpath:info-countries-2023-03-03-001.csv");
            Scanner scanner = new Scanner(file);
            int count = 1;
            while (scanner.hasNextLine()) {
                String[] strArray = scanner.nextLine().split(";");

                Country country = new Country();
                country.setCountryId(Integer.parseInt(strArray[0]));
                country.setName(strArray[1]);
                country.setOfficialName(strArray[2]);
                country.setCapital(strArray[3]);

                log.info("[run][count: " + count + "]");
                countryService.saveCountry(country);

                count++;
            }
            scanner.close();

        } catch (Exception e) {
            log.info("[run][Error: " + e.toString() + "]");
        }
        log.info("[run][Running CountryRunnerComponent on startup][END]");
    }

}
