package uz.tripshare.tripservice.service;
import org.springframework.stereotype.Service;
import uz.tripshare.tripservice.domain.Dto.Request.TripRequest;
import uz.tripshare.tripservice.domain.Dto.Response.TripResponse;
import uz.tripshare.tripservice.domain.entity.TripEntity;
import uz.tripshare.tripservice.repository.TripRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;

    public TripEntity createTrip(TripRequest tripRequest) {
        TripEntity tripEntity = mapRequestToEntity(tripRequest);
        return tripRepository.save(tripEntity);
    }

    @Override
    public TripResponse save(TripRequest request) {
        TripEntity tripEntity = mapRequestToEntity(request);
        TripEntity save = tripRepository.save(tripEntity);
        return mapEntityToResponse(save);
    }

    @Override
    public TripResponse update(Integer id, TripRequest request) {
        TripEntity tripEntity1 = mapRequestToEntity(request);
        tripEntity1.setId(id);
        TripEntity save = tripRepository.save(tripEntity1);
        return mapEntityToResponse(save);
    }

    @Override
    public TripResponse findById(Integer id) {
        TripEntity tripEntity = tripRepository.findById(id).get();
        return new TripResponse(
                tripEntity.getTitle(),
                tripEntity.getDescription(),
                tripEntity.getStartDate(),
                tripEntity.getEndDate(),
                tripEntity.getSeats(),
                tripEntity.getSpecial(),
                tripEntity.getDestinations(),
                tripEntity.getStays(),
                tripEntity.getInclusions(),
                tripEntity.getExclusions(),
                tripEntity.getTypes(),
                tripEntity.getStatus()
        );
    }

    @Override
    public List<TripResponse> findAll() {
        List<TripEntity> all = tripRepository.findAll();
        return mapListToResponse(all);
    }

    @Override
    public List<TripResponse> mapListToResponse(List<TripEntity> entities) {
        return entities.stream()
                .map(tripEntity -> new TripResponse(
                        tripEntity.getTitle(),
                        tripEntity.getDescription(),
                        tripEntity.getStartDate(),
                        tripEntity.getEndDate(),
                        tripEntity.getSeats(),
                        tripEntity.getSpecial(),
                        tripEntity.getDestinations(),
                        tripEntity.getStays(),
                        tripEntity.getInclusions(),
                        tripEntity.getExclusions(),
                        tripEntity.getTypes(),
                        tripEntity.getStatus()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        tripRepository.deleteById(id);
    }

    @Override
    public TripResponse mapEntityToResponse(TripEntity entity) {
        return new TripResponse(
                entity.getTitle(),
                entity.getDescription(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getSeats(),
                entity.getSpecial(),
                entity.getDestinations(),
                entity.getStays(),
                entity.getInclusions(),
                entity.getExclusions(),
                entity.getTypes(),
                entity.getStatus()
        );
    }
    @Override
    public TripEntity mapRequestToEntity(TripRequest request) {
        return new TripEntity(
                request.getTitle(),
                request.getDescription(),
                request.getStartDate(),
                request.getEndDate(),
                request.getSeats(),
                request.getSpecial(),
                request.getDestinations(),
                request.getStays(),
                request.getInclusions(),
                request.getExclusions(),
                request.getTypes(),
                request.getStatus()
        );
    }


}
