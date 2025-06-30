package mk.ukim.finki.labb1.repository;

import mk.ukim.finki.labb1.model.domen.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long> {
}
