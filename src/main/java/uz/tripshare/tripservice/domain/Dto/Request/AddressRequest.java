package uz.tripshare.tripservice.domain.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressRequest {
    private String country;
    private String region;
    private String district;
    private String street;
}
