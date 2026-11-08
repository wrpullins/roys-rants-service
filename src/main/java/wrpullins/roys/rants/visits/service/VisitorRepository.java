package wrpullins.roys.rants.visits.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitorRepository extends JpaRepository<VisitorDbo, Long> {

    Optional<VisitorDbo> findByVisitorKey(final String visitorKey);
}
