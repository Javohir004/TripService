package uz.tripshare.tripservice.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
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


    @ElementCollection
    private List<Integer> activities;
}
