package mk.ukim.finki.labb1.service.domain;

import mk.ukim.finki.labb1.model.views.HostsPerCountry;

import java.util.List;

public interface HostsPerCountryService {
    public List<HostsPerCountry> findAll();
    public void refreshMaterializedView();


    }
