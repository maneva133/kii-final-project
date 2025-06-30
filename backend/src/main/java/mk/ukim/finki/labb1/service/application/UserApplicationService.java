package mk.ukim.finki.labb1.service.application;

import mk.ukim.finki.labb1.dto.CreateUserDto;
import mk.ukim.finki.labb1.dto.DisplayUserDto;
import mk.ukim.finki.labb1.dto.LoginResponseDto;
import mk.ukim.finki.labb1.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {

    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

//    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
}
