package uz.tripshare.tripservice.service.trip;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tripshare.domain.common.Trip;
import uz.tripshare.domain.common.User;
import uz.tripshare.tripservice.clients.UserServiceClient;
import uz.tripshare.tripservice.domain.Dto.Request.TripRequest;
import uz.tripshare.tripservice.domain.entity.TripEntity;
import uz.tripshare.tripservice.repository.TripRepository;
import uz.tripshare.tripservice.service.destination.DestinationServiceImpl;
import uz.tripshare.tripservice.service.stay.StayServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final DestinationServiceImpl destinationService;
    private final StayServiceImpl stayService;
    private final UserServiceClient userServiceClient;


    @Override
    @Transactional
    public Trip save(TripRequest request) {
        TripEntity tripEntity = mapRequestToEntity(request);
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
                destinationService.mapListToResponse(tripEntity.getDestinations()),
                stayService.mapListToResponse(tripEntity.getStays()),
                tripEntity.getInclusions(),
                tripEntity.getExclusions(),
                tripEntity.getTypes(),
                tripEntity.getStatus(),
                tripEntity.getParticipants()
        );
    }

    @Override
    public TripEntity findEntityById(Integer id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trip not found with id: " + id));
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
                        destinationService.mapListToResponse(tripEntity.getDestinations()),
                        stayService.mapListToResponse(tripEntity.getStays()),
                        tripEntity.getInclusions(),
                        tripEntity.getExclusions(),
                        tripEntity.getTypes(),
                        tripEntity.getStatus(),
                        tripEntity.getParticipants())
                )
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
        tripRepository.deleteById(id);
    }

    @Override
    public Trip mapEntityToResponse(TripEntity entity) {
        Trip trip = new Trip(
                entity.getTitle(),
                entity.getDescription(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getSeats(),
                entity.getSpecial(),
                entity.getOwnerId(),
                destinationService.mapListToResponse(entity.getDestinations()),
                stayService.mapListToResponse(entity.getStays()),
                entity.getInclusions(),
                entity.getExclusions(),
                entity.getTypes(),
                entity.getStatus(),
                entity.getParticipants()
        );
        trip.setId(entity.getId());
        trip.setCreatedAt(entity.getCreated());
        trip.setUpdatedAt(entity.getUpdated());
        return trip;
    }

    @Override
    public TripEntity mapRequestToEntity(TripRequest request) {
        User user = userServiceClient.getUserById(request.getOwnerId());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return new TripEntity(
                request.getTitle(), request.getDescription(), request.getStartDate(),
                request.getEndDate(), request.getSeats(), request.getSpecial(),
                user.getId(),
                null,
                destinationService.mapListToEntity(request.getDestinations()),
                stayService.mapListToEntity(request.getStays()),
                request.getInclusions(), request.getExclusions(),
                request.getTypes(), request.getStatus()
        );
    }


}
