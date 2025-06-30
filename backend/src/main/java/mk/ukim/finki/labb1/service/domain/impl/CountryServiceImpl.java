package mk.ukim.finki.labb1.service.domain.impl;

import mk.ukim.finki.labb1.model.domen.Country;
import mk.ukim.finki.labb1.repository.CountryRepository;
import mk.ukim.finki.labb1.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        if(countryRepository.findById(id).isPresent()){
            Country country1 = countryRepository.findById(id).get();
            country1.setName(country.getName());
            country1.setContinent(country.getContinent());
            countryRepository.save(country1);
            return Optional.of(country1);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Country> save(Country country) {
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        if(countryRepository.findById(id).isPresent()){
            countryRepository.deleteById(id);
        }
    }
}
