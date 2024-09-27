package uz.tripshare.tripservice.domain.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.tripshare.tripservice.domain.enumerators.UserRole;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class UserEntity extends BaseEntity {
    private String name;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany
    private List<TripEntity> userTrips;

    @OneToOne
    private AddressEntity address;

}
