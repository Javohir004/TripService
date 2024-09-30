package uz.tripshare.tripservice.service;
import jakarta.persistence.EntityNotFoundException;
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
        TripEntity tripEntity = tripRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trip not found with id: " + id));

        return TripResponse.builder()
                .title(tripEntity.getTitle())
                .description(tripEntity.getDescription())
                .startDate(tripEntity.getStartDate())
                .endDate(tripEntity.getEndDate())
                .seats(tripEntity.getSeats())
                .special(tripEntity.getSpecial())
                .ownerId(tripEntity.getOwnerId())
                .destinations(tripEntity.getDestinations())
                .stays(tripEntity.getStays())
                .inclusions(tripEntity.getInclusions())
                .exclusions(tripEntity.getExclusions())
              ///  .types(tripEntity.getTypes())
                .status(tripEntity.getStatus())
                .build();
    }


    @Override
    public List<TripResponse> findAll() {
        List<TripEntity> all = tripRepository.findAll();
        return mapListToResponse(all);
    }

    @Override
    public List<TripResponse> findByOwnerId(Integer ownerId) {
    List<TripEntity> all = tripRepository.findByOwnerId(ownerId);
    return mapListToResponse(all);
    }

    @Override
    public List<TripResponse> mapListToResponse(List<TripEntity> entities) {
        return entities.stream()
                .map(tripEntity -> TripResponse.builder()
                        .title(tripEntity.getTitle())
                        .description(tripEntity.getDescription())
                        .startDate(tripEntity.getStartDate())
                        .endDate(tripEntity.getEndDate())
                        .seats(tripEntity.getSeats())
                        .special(tripEntity.getSpecial())
                        .ownerId(tripEntity.getOwnerId())
                        .destinations(tripEntity.getDestinations())
                        .stays(tripEntity.getStays())
                        .inclusions(tripEntity.getInclusions())
                        .exclusions(tripEntity.getExclusions())
                      ///  .types(tripEntity.getTypes())
                        .status(tripEntity.getStatus())
                        .build()
                )
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
        tripRepository.deleteById(id);
    }

    @Override
    public TripResponse mapEntityToResponse(TripEntity entity) {
        return TripResponse.builder()
                .title(entity.getTitle())
                .description(entity.getDescription())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .seats(entity.getSeats())
                .special(entity.getSpecial())
                .ownerId(entity.getOwnerId())
                .destinations(entity.getDestinations())
                .stays(entity.getStays())
                .inclusions(entity.getInclusions())
                .exclusions(entity.getExclusions())
               /// .types(entity.getTypes())
                .status(entity.getStatus())
                .build();
    }


    @Override
    public TripEntity mapRequestToEntity(TripRequest request) {
        return TripEntity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .seats(request.getSeats())
                .special(request.getSpecial())
                .ownerId(request.getOwnerId())
                .destinations(request.getDestinations())
                .stays(request.getStays())
                .inclusions(request.getInclusions())
                .exclusions(request.getExclusions())
///                .types(request.getTypes())
                .status(request.getStatus())
                .build();
    }



}
