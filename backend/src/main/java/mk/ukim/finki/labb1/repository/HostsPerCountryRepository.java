package mk.ukim.finki.labb1.repository;

import jakarta.transaction.Transactional;
import mk.ukim.finki.labb1.model.views.HostsPerCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface HostsPerCountryRepository extends JpaRepository<HostsPerCountry,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.hosts_per_country", nativeQuery = true)
    void refreshMaterializedView();

}
