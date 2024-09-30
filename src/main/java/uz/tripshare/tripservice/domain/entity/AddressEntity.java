package uz.tripshare.tripservice.domain.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "address")
public class AddressEntity extends BaseEntity {
    private String country;   // davlat
    private String region;     // viloyat
    private String district;   // tuman
    private String street;    // kocha va uy raqami

}
