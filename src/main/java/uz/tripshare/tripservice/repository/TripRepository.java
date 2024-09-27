package uz.tripshare.tripservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tripshare.tripservice.domain.entity.TripEntity;

@Repository
public interface TripRepository extends JpaRepository<TripEntity , Integer> {


}
