package mk.ukim.finki.labb1.service.domain;

import mk.ukim.finki.labb1.dto.CreateHostDto;
import mk.ukim.finki.labb1.model.domen.Guest;
import mk.ukim.finki.labb1.model.domen.Host;
import mk.ukim.finki.labb1.model.domen.Stay;

import java.util.List;
import java.util.Optional;

public interface GuestService {
    List<Guest> findAll();

    Optional<Guest> findById(Long id);

    Optional<Guest> update(Long id, Guest product);

    Optional<Guest> save(Guest product);

    void deleteById(Long id);

    Optional<Guest> addHost(Long id, CreateHostDto hostDto);
}
