package uz.tripshare.tripservice.domain.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.tripshare.tripservice.domain.enumerators.TripStatus;
import uz.tripshare.tripservice.domain.enumerators.TripType;


import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "trips")
public class TripEntity extends BaseEntity {
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer seats;
    private String special;

    private Integer ownerId;

    @OneToMany
    private List<DestinationEntity> destinations;

    @OneToMany
    private List<StayEntity> stays;

    @ElementCollection(targetClass = String.class)
    private List<String> inclusions;

    @ElementCollection(targetClass = String.class)
    private List<String> exclusions;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<TripType> types;

    @Enumerated(EnumType.STRING)
    private TripStatus status;

}
