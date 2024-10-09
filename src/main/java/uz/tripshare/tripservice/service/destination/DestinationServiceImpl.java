package uz.tripshare.tripservice.service.destination;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tripshare.domain.common.Destination;
import uz.tripshare.tripservice.domain.Dto.Request.DestinationRequest;
import uz.tripshare.tripservice.domain.entity.DestinationEntity;
import uz.tripshare.tripservice.service.activity.ActivityService;
import uz.tripshare.tripservice.service.activity.ActivityServiceImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {

    private final ActivityServiceImpl activityService;

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
        return destinations.stream().map(d -> new DestinationEntity(
                d.getDescription(), d.getLocation(), activityService.mapListToEntity(d.getActivities())
        )).toList();
    }
}
