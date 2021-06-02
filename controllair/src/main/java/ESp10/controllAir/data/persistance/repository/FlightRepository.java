package ESp10.controllAir.data.persistance.repository;

import ESp10.controllAir.data.persistance.entity.FlightEntity;
import java.time.LocalDateTime;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity, String> {
  Collection<FlightEntity> findByLastSeenBetween(LocalDateTime fromDate, LocalDateTime toDate);
}
