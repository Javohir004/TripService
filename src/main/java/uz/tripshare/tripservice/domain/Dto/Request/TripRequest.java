package uz.tripshare.tripservice.domain.Dto.Request;
import lombok.*;
import uz.tripshare.tripservice.domain.entity.DestinationEntity;
import uz.tripshare.tripservice.domain.entity.StayEntity;
import uz.tripshare.tripservice.domain.entity.UserEntity;
import uz.tripshare.tripservice.domain.enumerators.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TripRequest {
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer seats;
    private String special;
    private Integer ownerId;

    private List<DestinationEntity> destinations;

    private List<StayEntity> stays;

    private List<String> inclusions;

    private List<String> exclusions;

    private List<TripType> types;

    private TripStatus status;

}
