package mk.ukim.finki.labb1.service.domain.impl;

import mk.ukim.finki.labb1.dto.CreateHostDto;
import mk.ukim.finki.labb1.model.domen.Country;
import mk.ukim.finki.labb1.model.domen.Guest;
import mk.ukim.finki.labb1.repository.CountryRepository;
import mk.ukim.finki.labb1.repository.GuestRepository;
import mk.ukim.finki.labb1.service.domain.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;
    private final CountryRepository countryRepository;

    public GuestServiceImpl(GuestRepository guestRepository, CountryRepository countryRepository) {
        this.guestRepository = guestRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    @Override
    public Optional<Guest> findById(Long id) {
        return guestRepository.findById(id);
    }

    @Override
    public Optional<Guest> update(Long id, Guest product) {

        if (guestRepository.findById(id).isPresent()) {
            Guest g = guestRepository.findById(id).get();
            g.setName(product.getName());
            g.setSurname(product.getSurname());
            g.setHosts(product.getHosts());
            return Optional.of(g);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Guest> save(Guest product) {
        return Optional.of(guestRepository.save(product));
    }

    @Override
    public void deleteById(Long id) {
        guestRepository.deleteById(id);
    }

    @Override
    public Optional<Guest> addHost(Long id, CreateHostDto host) {
        if (guestRepository.findById(id).isPresent()) {
            Guest guest = guestRepository.findById(id).get();
            Country country = countryRepository.findById(host.country()).orElseThrow(RuntimeException::new);
            guest.getHosts().add(host.toHost(country));
            return Optional.of(guest);
        }
        return Optional.empty();
    }
}
