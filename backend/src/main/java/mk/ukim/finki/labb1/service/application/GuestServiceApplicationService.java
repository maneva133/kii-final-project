package mk.ukim.finki.labb1.service.application;

import mk.ukim.finki.labb1.dto.*;
import mk.ukim.finki.labb1.model.domen.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestServiceApplicationService {
    Optional<DisplayGuestDto> update(Long id, CreateGuestDto guestDto) ;

    Optional<DisplayGuestDto> save(CreateGuestDto guestDto);

    Optional<DisplayGuestDto> findById(Long id);

    List<DisplayGuestDto> findAll();

    void deleteById(Long id);
    Optional<DisplayGuestDto> addHost(Long id, CreateHostDto hostDto);

}
