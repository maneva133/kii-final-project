package mk.ukim.finki.labb1.service.domain.impl;

import mk.ukim.finki.labb1.model.views.HostsPerCountry;
import mk.ukim.finki.labb1.repository.HostsPerCountryRepository;
import mk.ukim.finki.labb1.service.domain.HostsPerCountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostsPerCountryViewServiceImpl implements HostsPerCountryService {


    private final HostsPerCountryRepository hostsPerCountryRepository;

    public HostsPerCountryViewServiceImpl(HostsPerCountryRepository hostsPerCountryRepository) {
        this.hostsPerCountryRepository = hostsPerCountryRepository;
    }

    @Override
    public List<HostsPerCountry> findAll() {
        return hostsPerCountryRepository.findAll();
    }

    @Override
    public void refreshMaterializedView() {
        hostsPerCountryRepository.refreshMaterializedView();

    }
}
