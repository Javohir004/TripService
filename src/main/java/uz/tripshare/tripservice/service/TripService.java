package uz.tripshare.tripservice.service;

import uz.tripshare.tripservice.domain.Dto.Request.TripRequest;
import uz.tripshare.tripservice.domain.Dto.Response.TripResponse;
import uz.tripshare.tripservice.domain.entity.TripEntity;

public interface TripService extends BaseService <TripEntity , TripResponse , TripRequest> {

}
