package mk.ukim.finki.labb1.service.domain.impl;

import mk.ukim.finki.labb1.events.HostAddingEvent;
import mk.ukim.finki.labb1.model.domen.Host;
import mk.ukim.finki.labb1.model.projections.HostProjection;
import mk.ukim.finki.labb1.repository.CountryRepository;
import mk.ukim.finki.labb1.repository.HostRepository;
import mk.ukim.finki.labb1.service.domain.HostService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;
    private final ApplicationEventPublisher eventPublisher;


    public HostServiceImpl(HostRepository hostRepository, CountryRepository countryRepository, ApplicationEventPublisher eventPublisher) {
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Optional<Host> update(Long id, Host host1) {
        if(hostRepository.findById(id).isPresent()){
            Host host = hostRepository.findById(id).get();
            host.setName(host1.getName());
            host.setSurname(host1.getSurname());
            host.setCountry(countryRepository.findById(host1.getCountry().getId()).get());
            hostRepository.save(host);
            eventPublisher.publishEvent(new HostAddingEvent(host));

            return Optional.of(host);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Host> save(Host host) {

        return Optional.of(hostRepository.save(host));
    }

    @Override
    public void deleteById(Long id) {
        if(hostRepository.findById(id).isPresent()){
            eventPublisher.publishEvent(new HostAddingEvent(hostRepository.findById(id).get()));

            hostRepository.deleteById(id);

        }
    }

    @Override
    public List<HostProjection> takeHostsByProjection() {
        return hostRepository.takeHostsByName();
    }
}
