package uz.tripshare.tripservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tripshare.tripservice.domain.entity.TripEntity;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<TripEntity , Integer> {

  List<TripEntity> findByOwnerId(Integer owner);


}
