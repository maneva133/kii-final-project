package mk.ukim.finki.labb1.dto;

import mk.ukim.finki.labb1.model.domen.Host;
import mk.ukim.finki.labb1.model.domen.Stay;
import mk.ukim.finki.labb1.model.enumeration.Category;

import java.util.List;
import java.util.stream.Collectors;

public record CreateStayDto(
        String name,
        Category category,
        Long hostId,
        int numRooms,
        boolean isAvailable
) {

    public static CreateStayDto from(Stay stay) {
        return new CreateStayDto(
                stay.getName(),
                stay.getCategory(),
                stay.getHost().getId(),
                stay.getNumRooms(),
                stay.isAvailable()
        );
    }

    public static List<CreateStayDto> from(List<Stay> products) {
        return products.stream().map(CreateStayDto::from).collect(Collectors.toList());
    }

    public Stay toStay(Category category, Host host) {
        return new Stay(name, category, host, numRooms,isAvailable);
    }
}
