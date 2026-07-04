package com.example.countryservice.controller;

import com.example.countryservice.model.Country;
import com.example.countryservice.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<Country> findByCode(@PathVariable String code) {
        Optional<Country> country = countryService.findByCode(code);
        return country.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country savedCountry = countryService.addCountry(country);
        return ResponseEntity.ok(savedCountry);
    }

    @PutMapping("/code/{code}")
    public ResponseEntity<Country> updateCountry(@PathVariable String code, @RequestBody Country updated) {
        Optional<Country> country = countryService.updateCountry(code, updated);
        return country.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/code/{code}")
    public ResponseEntity<Boolean> deleteByCode(@PathVariable String code) {
        boolean deleted = countryService.deleteByCode(code);
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Country>> searchByName(@RequestParam String name) {
        List<Country> countries = countryService.searchByName(name);
        return ResponseEntity.ok(countries);
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }
}
