package uz.tripshare.tripservice.service.activity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tripshare.domain.common.Activity;
import uz.tripshare.tripservice.domain.Dto.Request.ActivityRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Override
    public Activity save(ActivityRequest request) {
        return null;
    }

    @Override
    public Activity update(Integer id, ActivityRequest request) {
        return null;
    }

    @Override
    public Activity findById(Integer id) {
        return null;
    }

    @Override
    public Integer findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<Activity> findAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Activity mapEntityToResponse(Integer entity) {
        return null;
    }


    @Override
    public List<Activity> mapListToResponse(List<Integer> entities) {
        return List.of();
    }

    @Override
    public Integer mapRequestToEntity(ActivityRequest request) {
        return null;
    }

    @Transactional
    public List<Integer> mapListToEntity(List<Activity> activities) {
        return activities.stream().map(a -> {
                    Integer id = a.getId();
                    return id;
                }
        ).collect(Collectors.toList());
    }
}
