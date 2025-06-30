package mk.ukim.finki.labb1.service.domain;
import mk.ukim.finki.labb1.model.domen.Country;
import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> update(Long id, Country country);

    Optional<Country> save(Country country);

    void deleteById(Long id);
}
