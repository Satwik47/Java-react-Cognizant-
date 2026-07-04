package com.example.countryservice.service;

import com.example.countryservice.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Optional<Country> findByCode(String code);
    Country addCountry(Country country);
    Optional<Country> updateCountry(String code, Country updated);
    boolean deleteByCode(String code);
    List<Country> searchByName(String partialName);
    List<Country> getAllCountries();
}
