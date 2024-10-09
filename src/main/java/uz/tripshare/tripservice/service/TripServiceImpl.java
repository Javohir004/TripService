package uz.tripshare.tripservice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.tripshare.domain.common.Activity;
import uz.tripshare.domain.common.Destination;
import uz.tripshare.domain.common.Stay;
import uz.tripshare.domain.common.Trip;
import uz.tripshare.tripservice.clients.CustomerServiceClient;
import uz.tripshare.tripservice.domain.Dto.Request.TripRequest;
import uz.tripshare.tripservice.domain.entity.DestinationEntity;
import uz.tripshare.tripservice.domain.entity.StayEntity;
import uz.tripshare.tripservice.domain.entity.TripEntity;
import uz.tripshare.tripservice.repository.TripRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final CustomerServiceClient customerServiceClient;


    @Override
    public Trip save(TripRequest request) {
        TripEntity tripEntity = mapRequestToEntity(request);
        ///
        customerServiceClient.findById(request.getOwnerId());
        TripEntity save = tripRepository.save(tripEntity);
        return mapEntityToResponse(save);
    }

    @Override
    public Trip update(Integer id, TripRequest request) {
        TripEntity tripEntity1 = mapRequestToEntity(request);
        tripEntity1.setId(id);
        TripEntity save = tripRepository.save(tripEntity1);
        return mapEntityToResponse(save);
    }


    @Override
    public Trip findById(Integer id) {
        TripEntity tripEntity = tripRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trip not found with id: " + id));

        return new Trip(
                tripEntity.getTitle(),
                tripEntity.getDescription(),
                tripEntity.getStartDate(),
                tripEntity.getEndDate(),
                tripEntity.getSeats(),
                tripEntity.getSpecial(),
                tripEntity.getOwnerId(),
                getDestinations(tripEntity.getDestinations()),
                getStays(tripEntity.getStays()),
                tripEntity.getInclusions(),
                tripEntity.getExclusions(),
                tripEntity.getTypes(),
                tripEntity.getStatus(),
                null  // Add participants here
        );
    }



    @Override
    public List<Trip> findAll() {
        List<TripEntity> all = tripRepository.findAll();
        return mapListToResponse(all);
    }

    @Override
    public List<Trip> findByOwnerId(Integer ownerId) {
        List<TripEntity> all = tripRepository.findByOwnerId(ownerId);
        return mapListToResponse(all);
    }

    @Override
    public List<Trip> mapListToResponse(List<TripEntity> entities) {
        return entities.stream()
                .map(tripEntity -> new Trip(
                        tripEntity.getTitle(),
                        tripEntity.getDescription(),
                        tripEntity.getStartDate(),
                        tripEntity.getEndDate(),
                        tripEntity.getSeats(),
                        tripEntity.getSpecial(),
                        tripEntity.getOwnerId(),
                        getDestinations(tripEntity.getDestinations()),
                        getStays(tripEntity.getStays()),
                        tripEntity.getInclusions(),
                        tripEntity.getExclusions(),
                        tripEntity.getTypes(),
                        tripEntity.getStatus(),
                        null)  // Add participants here
                )
                .collect(Collectors.toList());
    }



    @Override
    public void delete(Integer id) {
        tripRepository.deleteById(id);
    }

    @Override
    public Trip mapEntityToResponse(TripEntity entity) {
        return new Trip(
                entity.getTitle(),
                entity.getDescription(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getSeats(),
                entity.getSpecial(),
                entity.getOwnerId(),
                getDestinations(entity.getDestinations()),
                getStays(entity.getStays()),
                entity.getInclusions(),
                entity.getExclusions(),
                entity.getTypes(),
                entity.getStatus(),
                null  // Add participants here
        );
    }


    private static List<Stay> getStays(List<StayEntity> stays) {
        return stays.stream().map(s -> new Stay(
                s.getName(), s.getReview(), s.getRating(), s.getPrice(), s.getRooms(), s.getTravellers(), s.getType()
        )).toList();
    }

    private static List<Destination> getDestinations(List<DestinationEntity> destinations) {
        return destinations.stream().map(d -> new Destination(
                d.getDescription(), d.getLocation(),
                d.getActivities().stream().map(a -> new Activity(
                        a.getName(), a.getDescription(), a.getLocation(), a.getPrice(), a.getCategory()
                )).toList()
        )).toList();

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
                .types(request.getTypes())
                .status(request.getStatus())
                .build();
    }


}
