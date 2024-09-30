package uz.tripshare.tripservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "destinations")
public class DestinationEntity extends BaseEntity {

    private String description;
    private String location;

    @OneToMany
    private List<ActivityEntity> activities;
}
