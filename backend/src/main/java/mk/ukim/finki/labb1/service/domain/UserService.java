package mk.ukim.finki.labb1.service.domain;

import mk.ukim.finki.labb1.model.domen.User;
import mk.ukim.finki.labb1.model.enumeration.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);
}

