package uz.tripshare.tripservice.service.activity;

import uz.tripshare.domain.common.Activity;
import uz.tripshare.tripservice.domain.Dto.Request.ActivityRequest;
import uz.tripshare.tripservice.domain.entity.ActivityEntity;

import java.util.List;

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
    public List<Activity> findAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Activity mapEntityToResponse(ActivityEntity entity) {
        return null;
    }

    @Override
    public List<Activity> mapListToResponse(List<ActivityEntity> entities) {
        return List.of();
    }

    @Override
    public ActivityEntity mapRequestToEntity(ActivityRequest request) {
        return null;
    }

    public List<ActivityEntity> mapListToEntity(List<Activity> activities) {
        return activities.stream().map(a -> new ActivityEntity(
                a.getName(), a.getDescription(), a.getLocation(),
                a.getPrice(), a.getCategory())
        ).toList();
    }
}
