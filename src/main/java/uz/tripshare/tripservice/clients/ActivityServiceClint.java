package uz.tripshare.tripservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import uz.tripshare.domain.common.Activity;

import java.util.List;

@FeignClient(name = "ACTIVITY-SERVICE", configuration = FeignClient.class, url = "http://localhost:8088", path = "api/activity")
public interface ActivityServiceClint {


    @PostMapping("/map-to-entity")
    List<Integer> mapListToEntityList(List<Activity> activityList);
}
