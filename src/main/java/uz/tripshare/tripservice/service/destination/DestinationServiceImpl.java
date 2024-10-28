package uz.tripshare.tripservice.service.destination;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tripshare.domain.common.Destination;
import uz.tripshare.tripservice.clients.ActivityServiceClint;
import uz.tripshare.tripservice.domain.Dto.Request.DestinationRequest;
import uz.tripshare.tripservice.domain.entity.DestinationEntity;
import uz.tripshare.tripservice.repository.DestinationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {

    private final ActivityServiceClint activityService;
    private final DestinationRepository destinationRepository;

    @Override
    public Destination save(DestinationRequest request) {
        return null;
    }

    @Override
    public Destination update(Integer id, DestinationRequest request) {
        return null;
    }

    @Override
    public Destination findById(Integer id) {
        return null;
    }

    @Override
    public DestinationEntity findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<Destination> findAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Destination mapEntityToResponse(DestinationEntity entity) {
        return null;
    }

    @Override
    public List<Destination> mapListToResponse(List<DestinationEntity> entities) {
        return List.of();
    }

    @Override
    public DestinationEntity mapRequestToEntity(DestinationRequest request) {
        return null;
    }


    @Transactional
    public List<DestinationEntity> mapListToEntity(List<Destination> destinations) {
        return destinations.stream().map(d -> {
            List<Integer> activityIds = activityService.mapListToEntityList(d.getActivities());
            DestinationEntity destinationEntity = new DestinationEntity(
                    d.getDescription(), d.getLocation(), activityIds);
            return destinationRepository.save(destinationEntity);
        }).collect(Collectors.toList());
    }
}

