package uz.tripshare.tripservice.service.address;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.tripshare.domain.common.Address;
import uz.tripshare.tripservice.domain.Dto.Request.AddressRequest;
import uz.tripshare.tripservice.domain.entity.AddressEntity;
import uz.tripshare.tripservice.repository.AddressRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public Address save(AddressRequest request) {
        AddressEntity addressEntity = mapRequestToEntity(request);
        addressRepository.save(addressEntity);
        return mapEntityToResponse(addressEntity);
    }

    @Override
    public Address update(Integer id, AddressRequest request) {
        AddressEntity address = findEntityById(id);
        address.setCountry(request.getCountry() == null ? address.getCountry() : request.getCountry());
        address.setRegion(request.getRegion() == null ? address.getRegion() : request.getRegion());
        address.setStreet(request.getStreet() == null ? address.getStreet() : request.getStreet());
        address.setDistrict(request.getDistrict() == null ? address.getDistrict() : request.getDistrict());
        return mapEntityToResponse(addressRepository.save(address));
    }

    @Override
    public Address findById(Integer id) {
        return null;
    }

    @Override
    public AddressEntity findEntityById(Integer id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found"));
    }

    @Override
    public List<Address> findAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Address mapEntityToResponse(AddressEntity entity) {
        Address address = new Address(
                entity.getCountry(), entity.getRegion(), entity.getDistrict(), entity.getStreet()
        );
        address.setId(entity.getId());
        address.setCreatedAt(entity.getCreated());
        address.setUpdatedAt(entity.getUpdated());
        return address;
    }

    @Override
    public List<Address> mapListToResponse(List<AddressEntity> entities) {
        return List.of();
    }

    @Override
    public AddressEntity mapRequestToEntity(AddressRequest request) {
        return new AddressEntity(
                request.getCountry(), request.getRegion(), request.getDistrict(), request.getStreet()
        );
    }
}
