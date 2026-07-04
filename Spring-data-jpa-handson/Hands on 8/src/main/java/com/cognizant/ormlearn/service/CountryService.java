package com.cognizant.ormlearn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Find Country
    @Transactional(readOnly = true)
    public Country findCountryByCode(String code) {

        Optional<Country> country = countryRepository.findById(code);

        if (country.isPresent()) {
            return country.get();
        }

        return null;
    }

    // Add Country
    @Transactional
    public void addCountry(Country country) {

        countryRepository.save(country);

    }

    // ************** Hands-on 8 ****************

    @Transactional
    public void updateCountry(String code, String name) {

        Optional<Country> countryOptional = countryRepository.findById(code);

        if (countryOptional.isPresent()) {

            Country country = countryOptional.get();

            // Update country name
            country.setName(name);

            // Save updated object
            countryRepository.save(country);

        } else {

            System.out.println("Country not found.");

        }

    }

}
