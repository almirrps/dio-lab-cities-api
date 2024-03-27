package com.github.almirrps.countries.repositories;

import com.github.almirrps.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
