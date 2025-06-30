package mk.ukim.finki.labb1.web;

import io.swagger.v3.oas.annotations.Operation;
import mk.ukim.finki.labb1.model.domen.Stay;
import mk.ukim.finki.labb1.service.domain.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Operation(summary = "Adding a Reservation", description = "Creating a new reservation")
    @PostMapping("/add/{accommodationId}")
    public ResponseEntity<String> addToTemp(@RequestBody String username, @PathVariable Long accommodationId) {
        String message = reservationService.addReservationToUser(username, accommodationId);
        return ResponseEntity.ok(message);
    }

    @Operation(summary = "Reservation confirm", description = "Confirming list of reservations")
    @PostMapping("/confirm")
    public ResponseEntity<String> confirm(@RequestBody String username) {
        String message = reservationService.confirmReservations(username);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/mostPopular")
    public ResponseEntity<Stay> mostPopularStay(){
        Stay stay = reservationService.mostPopularStay();
        return ResponseEntity.ok().build();
    }
}

