package mk.ukim.finki.labb1.service.domain;

import mk.ukim.finki.labb1.model.domen.Stay;
import mk.ukim.finki.labb1.model.enumeration.Category;

import java.util.Map;
import java.util.Optional;

public interface ReservationService {

    String addReservationToUser(String userId,Long stayId);
    String confirmReservations(String username);
     Stay mostPopularStay();
}
