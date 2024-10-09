package uz.tripshare.tripservice.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.tripshare.domain.enumerators.TripStatus;
import uz.tripshare.domain.enumerators.TripType;


import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "trips")
@Builder
public class TripEntity extends BaseEntity {

    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer seats;
    private String special;



    private Integer ownerId;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<DestinationEntity> destinations;

    @OneToMany
    private List<StayEntity> stays;

    @ElementCollection(targetClass = String.class)
    private List<String> inclusions;

    @ElementCollection(targetClass = String.class)
    private List<String> exclusions;

    @ElementCollection(targetClass = TripType.class)
    @CollectionTable(name = "trip_types", joinColumns = @JoinColumn(name = "trip_id"))
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private List<TripType> types;

    @Enumerated(EnumType.STRING)
    private TripStatus status;

}
