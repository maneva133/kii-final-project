package mk.ukim.finki.labb1.service.application.impl;

import mk.ukim.finki.labb1.dto.CreateHostDto;
import mk.ukim.finki.labb1.dto.DisplayHostDto;
import mk.ukim.finki.labb1.repository.CountryRepository;
import mk.ukim.finki.labb1.service.application.HostApplicationService;
import mk.ukim.finki.labb1.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {
    private final HostService hostService;
    private final CountryRepository countryRepository;

    public HostApplicationServiceImpl(HostService hostService, CountryRepository countryRepository) {
        this.hostService = hostService;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto) {

        return hostService.update(id,createHostDto.toHost(
                countryRepository.findById(createHostDto.country()).get()
        )).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> save(CreateHostDto createHostDto) {
        return
                hostService.save(createHostDto.toHost(
                        countryRepository.findById(createHostDto.country()).get()
                )).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return hostService.findById(id).map(DisplayHostDto::from);
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return hostService.findAll().stream().map(DisplayHostDto::from).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        hostService.deleteById(id);
    }
}
