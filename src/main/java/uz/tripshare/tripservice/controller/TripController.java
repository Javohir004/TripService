package uz.tripshare.tripservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.tripshare.tripservice.domain.Dto.Request.TripRequest;
import uz.tripshare.tripservice.domain.Dto.Response.TripResponse;
import uz.tripshare.tripservice.service.TripService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trip")
public class TripController {

    private final TripService tripService;

    @PostMapping("/create-trip")
    public TripResponse createTrip(@RequestBody TripRequest tripRequest) {
       return tripService.save(tripRequest);
    }


    @DeleteMapping("/delete-trip/{tripId}")
    public void deleteTrip(@PathVariable("tripId") Integer tripId) {
        tripService.delete(tripId);
    }

    @PostMapping("/update-trip/{tripId}")
    public TripResponse updateTrip(@PathVariable("tripId") Integer tripId, @RequestBody TripRequest tripRequest) {
        return tripService.update(tripId, tripRequest);
    }


    @GetMapping("/findTripBy-userId")
    public List<TripResponse> getTripById(@PathVariable("tripId") Integer ownerId) {
        return tripService.findByOwnerId(ownerId);
    }





}
