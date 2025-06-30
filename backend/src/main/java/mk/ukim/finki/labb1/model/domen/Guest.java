package mk.ukim.finki.labb1.model.domen;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToMany
    private List<Host> hosts;

    public Guest(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.hosts = new ArrayList<>();
    }

    public Guest() {

    }
}
