package mk.ukim.finki.labb1.service.application;

import mk.ukim.finki.labb1.dto.CreateHostDto;
import mk.ukim.finki.labb1.dto.CreateStayDto;
import mk.ukim.finki.labb1.dto.DisplayHostDto;
import mk.ukim.finki.labb1.dto.DisplayStayDto;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {
    Optional<DisplayHostDto> update(Long id, CreateHostDto stayDto) ;

    Optional<DisplayHostDto> save(CreateHostDto stayDto);

    Optional<DisplayHostDto> findById(Long id);

    List<DisplayHostDto> findAll();

    void deleteById(Long id);
}
