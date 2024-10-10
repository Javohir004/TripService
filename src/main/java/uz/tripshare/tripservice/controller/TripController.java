package uz.tripshare.tripservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.tripshare.domain.common.Trip;
import uz.tripshare.tripservice.domain.Dto.Request.TripRequest;
import uz.tripshare.tripservice.service.trip.TripServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/api/trip")
@RequiredArgsConstructor
public class TripController {

    private final TripServiceImpl tripService;

    @PostMapping("/create")
    public Trip createTrip(@RequestBody TripRequest tripRequest) {
       return tripService.save(tripRequest);
    }


    @DeleteMapping("/delete/{tripId}")
    public void deleteTrip(@PathVariable("tripId") Integer tripId) {
        tripService.delete(tripId);
    }

    @PostMapping("/edit/{tripId}")
    public Trip updateTrip(@PathVariable("tripId") Integer tripId, @RequestBody TripRequest tripRequest) {
        return tripService.update(tripId, tripRequest);
    }


    @GetMapping("/user-trips/{userId}")
    public List<Trip> getTripById(@PathVariable("userId") Integer ownerId) {
        return tripService.findByOwnerId(ownerId);
    }

    @GetMapping("/add-participants/{userId}/{tripId}")
    public Trip addParticipants(@PathVariable("userId") Integer userId ,@PathVariable("tripId") Integer tripId ) {
        return tripService.saveParticipants(userId, tripId);
    }


}
