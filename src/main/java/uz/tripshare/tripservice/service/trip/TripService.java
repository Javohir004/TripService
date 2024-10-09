package uz.tripshare.tripservice.service.trip;

import uz.tripshare.domain.common.Trip;
import uz.tripshare.tripservice.domain.Dto.Request.TripRequest;
import uz.tripshare.tripservice.domain.entity.TripEntity;
import uz.tripshare.tripservice.service.BaseService;

import java.util.List;

public interface TripService extends BaseService<TripEntity , Trip , TripRequest> {

    List<Trip> findByOwnerId(Integer ownerId);
}
