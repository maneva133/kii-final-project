package mk.ukim.finki.labb1.repository;

import mk.ukim.finki.labb1.model.domen.Reservation;
import mk.ukim.finki.labb1.model.domen.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findByUserAndConfirmedIsFalse(User user);

    List<Reservation> findAllByUser_Username(String username);


}
