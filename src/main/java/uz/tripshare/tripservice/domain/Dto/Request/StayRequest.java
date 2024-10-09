package uz.tripshare.tripservice.domain.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.tripshare.domain.enumerators.StayType;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StayRequest {
    private String name;
    private String review;
    private Double rating;
    private Double price;
    private Integer rooms;
    private Integer travellers;
    private StayType type;
}
