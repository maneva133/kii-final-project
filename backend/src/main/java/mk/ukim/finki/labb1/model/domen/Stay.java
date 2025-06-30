package mk.ukim.finki.labb1.model.domen;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.labb1.model.enumeration.Category;

@Data
@Entity
public class Stay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;
    private int numRooms;
    private boolean isAvailable;

    public Stay(String name, Category category, Host host, int numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.isAvailable=true;
    }

    public Stay() {
        this.isAvailable=true;

    }

    public Stay(Long id, String name, Category category, Host host, int numRooms) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.isAvailable=true;
    }

    public Stay(String name, Category category, Host host, int numRooms, boolean isAvailable) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.isAvailable = isAvailable;
    }
}
