package com.example.countryservice.service.impl;

import com.example.countryservice.model.Country;
import com.example.countryservice.repository.CountryRepository;
import com.example.countryservice.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Country> findByCode(String code) {
        return repository.findByCode(code.toUpperCase());
    }

    @Override
    public Country addCountry(Country country) {
        country.setCode(country.getCode().toUpperCase());
        return repository.save(country);
    }

    @Override
    public Optional<Country> updateCountry(String code, Country updated) {
        Optional<Country> existing = repository.findByCode(code.toUpperCase());
        if (existing.isPresent()) {
            Country c = existing.get();
            c.setName(updated.getName());
            return Optional.of(repository.save(c));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteByCode(String code) {
        Optional<Country> existing = repository.findByCode(code.toUpperCase());
        if (existing.isPresent()) {
            repository.delete(existing.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Country> searchByName(String partialName) {
        return repository.findByNameContainingIgnoreCase(partialName);
    }

    @Override
    public List<Country> getAllCountries() {
        return repository.findAll();
    }
}
