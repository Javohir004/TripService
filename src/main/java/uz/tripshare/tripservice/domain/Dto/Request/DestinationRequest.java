package uz.tripshare.tripservice.domain.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.tripshare.domain.common.Activity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DestinationRequest {
    private String description;
    private String location;
    private List<ActivityRequest> activities;

}
