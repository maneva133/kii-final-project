package mk.ukim.finki.labb1.service.domain;

import mk.ukim.finki.labb1.model.domen.Host;
import mk.ukim.finki.labb1.model.domen.Stay;
import mk.ukim.finki.labb1.model.projections.HostProjection;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();

    Optional<Host> findById(Long id);

    Optional<Host> update(Long id, Host product);

    Optional<Host> save(Host product);

    void deleteById(Long id);

    List<HostProjection> takeHostsByProjection();
}
