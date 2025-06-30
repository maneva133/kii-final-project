package mk.ukim.finki.labb1.repository;

import mk.ukim.finki.labb1.model.domen.Stay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayRepository extends JpaRepository<Stay,Long> {
}
