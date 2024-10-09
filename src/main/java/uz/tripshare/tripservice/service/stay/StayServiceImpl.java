package uz.tripshare.tripservice.service.stay;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tripshare.domain.common.Stay;
import uz.tripshare.tripservice.domain.Dto.Request.StayRequest;
import uz.tripshare.tripservice.domain.entity.StayEntity;

import java.util.List;

@Service
public class StayServiceImpl implements StayService{
    @Override
    public Stay save(StayRequest request) {
        return null;
    }

    @Override
    public Stay update(Integer id, StayRequest request) {
        return null;
    }

    @Override
    public Stay findById(Integer id) {
        return null;
    }

    @Override
    public StayEntity findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<Stay> findAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Stay mapEntityToResponse(StayEntity entity) {
        return null;
    }

    @Override
    public List<Stay> mapListToResponse(List<StayEntity> entities) {
        return List.of();
    }

    @Override
    public StayEntity mapRequestToEntity(StayRequest request) {
        return null;
    }

    @Transactional
    public List<StayEntity> mapListToEntity(List<Stay> stays) {
        return stays.stream().map(s-> new StayEntity(
                s.getName(), s.getReview(), s.getRating(),
                s.getPrice(), s.getRooms(), s.getTravellers(), s.getType()
        )).toList();
    }
}
