package mk.ukim.finki.labb1.dto;

import mk.ukim.finki.labb1.model.domen.Guest;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayGuestDto(Long id,
                              String name,
                              String surname
) {
    public static DisplayGuestDto from(Guest guest) {
        return new DisplayGuestDto(guest.getId(), guest.getName(), guest.getSurname());
    }

    public static List<DisplayGuestDto> from(List<Guest> guests) {
        return guests.stream()
                .map(DisplayGuestDto::from).collect(Collectors.toList());
    }

}
