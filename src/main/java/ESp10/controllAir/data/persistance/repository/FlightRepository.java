package ESp10.controllAir.data.persistance.repository;

import ESp10.controllAir.data.persistance.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;

public interface FlightRepository extends JpaRepository<FlightEntity, String> {
  Collection<FlightEntity> findByLastSeenBetween(LocalDateTime fromDate, LocalDateTime toDate);
}
