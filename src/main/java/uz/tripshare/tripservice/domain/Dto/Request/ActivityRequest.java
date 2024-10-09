package uz.tripshare.tripservice.domain.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.tripshare.domain.enumerators.Category;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ActivityRequest {
    private String name;
    private String description;
    private String location;
    private Double price;
    private Category category;

}
