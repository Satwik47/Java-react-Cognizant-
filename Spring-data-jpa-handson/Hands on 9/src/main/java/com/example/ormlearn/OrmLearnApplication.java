package com.example.ormlearn;

import com.example.ormlearn.entity.Country;
import com.example.ormlearn.repository.CountryRepository;
import com.example.ormlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testDeleteCountry();
    }

    @Transactional
    public void testDeleteCountry() {
        // Add a country first (simulating the add country hands on)
        Country country = new Country("XYZ", "Test Country");
        countryRepository.save(country);
        System.out.println("Country added: " + country.getCode() + " - " + country.getName());

        // Call the delete method based on the country code
        countryService.deleteCountry("XYZ");
        System.out.println("Country deleted with code: XYZ");

        // Check in database if the country is deleted
        boolean exists = countryRepository.existsById("XYZ");
        System.out.println("Country exists after deletion: " + exists);

        if (!exists) {
            System.out.println("Test PASSED: Country successfully deleted");
        } else {
            System.out.println("Test FAILED: Country still exists in database");
        }
    }
}
