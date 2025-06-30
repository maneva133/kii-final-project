package mk.ukim.finki.labb1.dto;

import mk.ukim.finki.labb1.model.domen.Host;
import mk.ukim.finki.labb1.model.domen.Stay;
import mk.ukim.finki.labb1.model.enumeration.Category;

import java.util.List;
import java.util.stream.Collectors;


public record DisplayStayDto(
        Long id,
        String name,
        Category category,
        Long host,
        int numRooms,
        boolean isAvailable
) {

    public static DisplayStayDto from(Stay stay) {
        return new DisplayStayDto(
                stay.getId(),
                stay.getName(),
                stay.getCategory(),
                stay.getHost().getId(),
                stay.getNumRooms(),
                stay.isAvailable()
        );
    }

    public static List<DisplayStayDto> from(List<Stay> products) {
        return products.stream().map(DisplayStayDto::from).collect(Collectors.toList());
    }

    public Stay toStay(Category category, Host host) {
        return new Stay(name, category, host, numRooms,isAvailable);
    }
}

