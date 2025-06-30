package mk.ukim.finki.labb1.service.application.impl;

import mk.ukim.finki.labb1.dto.CreateGuestDto;
import mk.ukim.finki.labb1.dto.CreateHostDto;
import mk.ukim.finki.labb1.dto.DisplayGuestDto;
import mk.ukim.finki.labb1.service.application.GuestServiceApplicationService;
import mk.ukim.finki.labb1.service.domain.GuestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuestServiceApplicationImpl implements GuestServiceApplicationService {

    public final GuestService guestService;

    public GuestServiceApplicationImpl(GuestService guestService) {
        this.guestService = guestService;
    }

    @Override
    public Optional<DisplayGuestDto> update(Long id, CreateGuestDto guestDto) {
        return guestService.update(id,guestDto.toGuest()).map(DisplayGuestDto::from);
    }

    @Override
    public Optional<DisplayGuestDto> save(CreateGuestDto guestDto) {
        return guestService.save(guestDto.toGuest()).map(DisplayGuestDto::from);
    }

    @Override
    public Optional<DisplayGuestDto> findById(Long id) {
        return guestService.findById(id).map(DisplayGuestDto::from);
    }

    @Override
    public List<DisplayGuestDto> findAll() {
        return guestService.findAll().stream().map(DisplayGuestDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        guestService.deleteById(id);
    }

    @Override
    public Optional<DisplayGuestDto> addHost(Long id, CreateHostDto hostDto) {
       return guestService.addHost(id,hostDto).map(DisplayGuestDto::from);
    }
}
