package mk.ukim.finki.labb1.dto;

import mk.ukim.finki.labb1.model.domen.User;
import mk.ukim.finki.labb1.model.enumeration.Role;

public record DisplayUserDto(String username, String name, String surname, Role role) {

    public static DisplayUserDto from(User user) {
        return new DisplayUserDto(
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getRole()
        );
    }

    public User toUser() {
        return new User(username, name, surname, role.name());
    }
}

