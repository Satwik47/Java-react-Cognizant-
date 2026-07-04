package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

	@Autowired
	CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		testUpdateCountry();

	}

	private void testUpdateCountry() {

		System.out.println("----- Before Update -----");

		Country country = countryService.findCountryByCode("IN");

		System.out.println(country);

		System.out.println();

		countryService.updateCountry("IN", "Republic of India");

		System.out.println("----- After Update -----");

		Country updatedCountry = countryService.findCountryByCode("IN");

		System.out.println(updatedCountry);

	}

}
