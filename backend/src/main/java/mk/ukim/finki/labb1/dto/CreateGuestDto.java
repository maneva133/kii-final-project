package mk.ukim.finki.labb1.dto;

import mk.ukim.finki.labb1.model.domen.Guest;
import mk.ukim.finki.labb1.model.domen.Host;
import mk.ukim.finki.labb1.model.domen.Stay;
import mk.ukim.finki.labb1.model.enumeration.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record CreateGuestDto(String name,
                             String surname
) {


    public static CreateGuestDto from(Guest guest) {
        return new CreateGuestDto(
                guest.getName(),
                guest.getSurname());
    }

    public static List<CreateGuestDto> from(List<Guest> guests) {
        return guests.stream().map(CreateGuestDto::from).collect(Collectors.toList());
    }


    public Guest toGuest() {
        return new Guest(name, surname);
    }

}
