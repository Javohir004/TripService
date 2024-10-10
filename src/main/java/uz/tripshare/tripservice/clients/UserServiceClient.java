package uz.tripshare.tripservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.tripshare.domain.common.User;
import uz.tripshare.tripservice.config.FeignConfig;

@FeignClient(name = "USER-SERVICE", configuration = FeignConfig.class, url = "http://localhost:8081", path = "/api/user")
public interface UserServiceClient {

    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") Integer id);


}
