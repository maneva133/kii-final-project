package mk.ukim.finki.labb1.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;


@Data
@Entity
@Subselect("SELECT * FROM stays_per_host")
@Immutable
public class StaysPerHostView {
    @Id
    @Column(name = "host_id")
    private Long hostId;
    @Column(name = "num_stays")
    private Integer numStays;
}
