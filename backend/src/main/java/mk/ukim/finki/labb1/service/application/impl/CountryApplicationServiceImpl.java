package mk.ukim.finki.labb1.service.application.impl;

import mk.ukim.finki.labb1.dto.CreateCountryDto;
import mk.ukim.finki.labb1.dto.DisplayCountryDto;
import mk.ukim.finki.labb1.service.application.CountryApplicationService;
import mk.ukim.finki.labb1.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {
    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto stayDto) {
        return countryService.update(id,stayDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> save(CreateCountryDto stayDto) {
        return countryService.save(stayDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService.findById(id).map(DisplayCountryDto::from);
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return countryService.findAll().stream().map(
                DisplayCountryDto::from
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {

        countryService.deleteById(id);
    }
}
