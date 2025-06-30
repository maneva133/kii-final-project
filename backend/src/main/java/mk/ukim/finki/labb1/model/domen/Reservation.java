package mk.ukim.finki.labb1.model.domen;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;
    @ManyToOne
    private Stay stay;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private boolean confirmed = false;
}
