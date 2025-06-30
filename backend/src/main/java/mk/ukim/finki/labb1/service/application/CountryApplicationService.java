package mk.ukim.finki.labb1.service.application;

import mk.ukim.finki.labb1.dto.CreateCountryDto;
import mk.ukim.finki.labb1.dto.CreateHostDto;
import mk.ukim.finki.labb1.dto.DisplayCountryDto;
import mk.ukim.finki.labb1.dto.DisplayHostDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    Optional<DisplayCountryDto> update(Long id, CreateCountryDto stayDto) ;

    Optional<DisplayCountryDto> save(CreateCountryDto stayDto);

    Optional<DisplayCountryDto> findById(Long id);

    List<DisplayCountryDto> findAll();

    void deleteById(Long id);
}
