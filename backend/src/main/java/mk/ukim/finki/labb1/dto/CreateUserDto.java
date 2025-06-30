package mk.ukim.finki.labb1.dto;

import mk.ukim.finki.labb1.model.domen.User;
import mk.ukim.finki.labb1.model.enumeration.Role;

public record CreateUserDto(
        String username,
        String password,
        String repeatPassword,
        String name,
        String surname,
        Role role
) {

    /*
        todo: add repeat password logic
     */
    public User toUser() {
        return new User(username, password, name, surname, role);
    }
}

