package uz.tripshare.tripservice.domain.Dto.Request;
import lombok.*;
import uz.tripshare.domain.common.Destination;
import uz.tripshare.domain.common.Stay;
import uz.tripshare.domain.enumerators.TripStatus;
import uz.tripshare.domain.enumerators.TripType;
import uz.tripshare.tripservice.domain.entity.DestinationEntity;
import uz.tripshare.tripservice.domain.entity.StayEntity;


import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TripRequest {
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer seats;
    private String special;
    private Integer ownerId;

    private List<Destination> destinations;

    private List<Stay> stays;

    private List<String> inclusions;

    private List<String> exclusions;

    private List<TripType> types;

    private TripStatus status;

}
