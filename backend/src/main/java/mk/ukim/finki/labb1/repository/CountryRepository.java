package mk.ukim.finki.labb1.repository;

import mk.ukim.finki.labb1.model.domen.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
