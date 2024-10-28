package uz.tripshare.tripservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.tripshare.tripservice.domain.entity.DestinationEntity;

public interface DestinationRepository extends JpaRepository<DestinationEntity,Integer> {
}
