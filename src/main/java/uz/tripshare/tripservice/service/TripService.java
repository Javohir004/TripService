package uz.tripshare.tripservice.service;

import uz.tripshare.domain.common.Trip;
import uz.tripshare.tripservice.domain.Dto.Request.TripRequest;
import uz.tripshare.tripservice.domain.entity.TripEntity;

import java.util.List;

public interface TripService extends BaseService <TripEntity , Trip , TripRequest> {

    public List<Trip> findByOwnerId(Integer ownerId);
}
