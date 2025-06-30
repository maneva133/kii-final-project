package mk.ukim.finki.labb1.dto;

import mk.ukim.finki.labb1.model.domen.Country;
import mk.ukim.finki.labb1.model.domen.Guest;

import java.util.List;
import java.util.stream.Collectors;

public record CreateCountryDto(String name, String continent) {



    public static CreateCountryDto from(Country country) {
        return new CreateCountryDto(
                country.getName(),
                country.getContinent());
    }

    public static List<CreateCountryDto> from(List<Country> guests) {
        return guests.stream().map(CreateCountryDto::from).collect(Collectors.toList());
    }


    public Country toCountry() {
        return new Country(name, continent);
    }
}
