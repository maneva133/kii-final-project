package mk.ukim.finki.labb1.service.application.impl;

import mk.ukim.finki.labb1.dto.CreateUserDto;
import mk.ukim.finki.labb1.dto.DisplayUserDto;
import mk.ukim.finki.labb1.dto.LoginResponseDto;
import mk.ukim.finki.labb1.dto.LoginUserDto;
import mk.ukim.finki.labb1.model.domen.User;
import mk.ukim.finki.labb1.security.JwtHelper;
import mk.ukim.finki.labb1.service.application.UserApplicationService;
import mk.ukim.finki.labb1.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserService userService;
    private final JwtHelper jwtHelper;



    public UserApplicationServiceImpl(UserService userService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
    }



    @Override
    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
        User user = userService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.repeatPassword(),
                createUserDto.name(),
                createUserDto.surname(),
                createUserDto.role()
        );
        return Optional.of(DisplayUserDto.from(user));
    }

    @Override
    public Optional<LoginResponseDto> login(LoginUserDto loginUserDto) {
        User user = userService.login(
                loginUserDto.username(),
                loginUserDto.password());

        String token = jwtHelper.generateToken(user);

        return Optional.of(new LoginResponseDto(token));

    }

    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userService.findByUsername(username)));
    }

}
