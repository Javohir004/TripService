package uz.tripshare.tripservice.domain.Dto.Response;
import lombok.*;
import uz.tripshare.tripservice.domain.entity.DestinationEntity;
import uz.tripshare.tripservice.domain.entity.StayEntity;
import uz.tripshare.tripservice.domain.enumerators.TripStatus;
import uz.tripshare.tripservice.domain.enumerators.TripType;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TripResponse extends BaseResponse {

    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer seats;
    private String special;


    private List<DestinationEntity> destinations;

    private List<StayEntity> stays;

    private List<String> inclusions;

    private List<String> exclusions;

    private List<TripType> types;

    private TripStatus status;
}
