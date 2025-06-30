package mk.ukim.finki.labb1.service.domain.impl;

import mk.ukim.finki.labb1.model.domen.Reservation;
import mk.ukim.finki.labb1.model.domen.Stay;
import mk.ukim.finki.labb1.model.domen.User;
import mk.ukim.finki.labb1.repository.ReservationRepository;
import mk.ukim.finki.labb1.service.application.StayApplicationService;
import mk.ukim.finki.labb1.service.application.UserApplicationService;
import mk.ukim.finki.labb1.service.domain.ReservationService;
import mk.ukim.finki.labb1.service.domain.StayService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationServiceImpl implements ReservationService {
    public final UserApplicationService userApplicationService;
    public final StayApplicationService stayApplicationService;
    public final StayService stayService;
    public final ReservationRepository reservationRepository;

    public ReservationServiceImpl(UserApplicationService userApplicationService, StayApplicationService stayApplicationService, StayService stayService, ReservationRepository reservationRepository) {
        this.userApplicationService = userApplicationService;
        this.stayApplicationService = stayApplicationService;
        this.stayService = stayService;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public String addReservationToUser(String username, Long stayId) {

        Stay stay = stayService.findById(stayId)
                .orElseThrow(()->new RuntimeException("Stay does not exist"));

        if(!stay.isAvailable()){
            return "Stay is not available";
        }

        User user = userApplicationService.findByUsername(username)
                .orElseThrow(()->new RuntimeException("User does not exist")).toUser();

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setStay(stay);

        reservationRepository.save(reservation);
        return "Stay is added to the list";
    }

    public String confirmReservations(String userId) {
        List<Reservation> reservations = reservationRepository.findAllByUser_Username(userId);

        for (Reservation res : reservations) {
            Stay acc = res.getStay();

            if (!acc.isAvailable()) {
                return "Some are already reserved!";
            }

            acc.setAvailable(false);
            stayService.save(acc);
        }

        // Delete temporary reservations
        reservationRepository.deleteAll(reservations);

        return "Successfully reserved all stays.";
    }
    public Stay mostPopularStay(){

        List<Reservation> reservations = reservationRepository.findAll();
        Map<Long,Integer> map = new HashMap<>();

        for(Reservation r : reservations){
            Long stayId = r.getStay().getId();
            map.putIfAbsent(stayId,0);
            map.put(stayId,map.get(stayId)+1);
        }

        Optional<Map.Entry<Long, Integer>> maxEntry = map.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if(maxEntry.isPresent()){
            Long maxId = maxEntry.get().getKey();
            return stayService.findById(maxId)
                    .orElseThrow();
        } else {
            throw new NoSuchElementException("No reservations found");

        }
    }


}
