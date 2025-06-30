package mk.ukim.finki.labb1.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import mk.ukim.finki.labb1.model.domen.Country;
import mk.ukim.finki.labb1.model.domen.Host;
import mk.ukim.finki.labb1.model.domen.Stay;
import mk.ukim.finki.labb1.model.enumeration.Category;

import java.util.List;
import java.util.stream.Collectors;

public record GetAllStaysDto(Long id,
                             String name,
                             Category category,
                             String hostName,
                             String hostSurname,
                             String countryName,
                             String countryContinent,
                             int numRooms) {

    public static GetAllStaysDto from(Stay stay) {
        return new GetAllStaysDto(
                stay.getId(),
                stay.getName(),
                stay.getCategory(),
                stay.getHost().getName(),
                stay.getHost().getSurname(),

                stay.getHost().getCountry().getName(),
                stay.getHost().getCountry().getContinent(),

                stay.getNumRooms()
        );
    }

    public static List<CreateStayDto> from(List<Stay> products) {
        return products.stream().map(CreateStayDto::from).collect(Collectors.toList());
    }

}
