package mk.ukim.finki.labb1.repository;

import jakarta.transaction.Transactional;
import mk.ukim.finki.labb1.model.views.StaysPerHostView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaysPerHostViewRepository extends JpaRepository<StaysPerHostView,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.stays_per_host", nativeQuery = true)
    void refreshMaterializedView();

}
