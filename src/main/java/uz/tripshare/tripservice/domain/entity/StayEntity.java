package uz.tripshare.tripservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import uz.tripshare.tripservice.domain.enumerators.StayType;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "stays")
public class StayEntity extends BaseEntity {

    private String name;
    private String review;
    private Double rating;
    private Double price;
    private Integer rooms;
    private Integer travellers;

    @Enumerated(EnumType.STRING)
    private StayType type;

}
