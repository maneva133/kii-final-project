package mk.ukim.finki.labb1.repository;

import mk.ukim.finki.labb1.model.domen.Host;
import mk.ukim.finki.labb1.model.projections.HostProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HostRepository extends JpaRepository<Host,Long> {
    @Query("select h from Host h")
    List<HostProjection> takeHostsByName();
}
