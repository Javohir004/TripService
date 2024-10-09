package uz.tripshare.tripservice.clients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.tripshare.tripservice.config.FeignConfig;
import uz.tripshare.tripservice.domain.Dto.Response.TripResponse;


@FeignClient(name = "CUSTOMER-SERVICE", configuration = FeignConfig.class , url = "http://localhost:8081", path = "/api/user")
public interface CustomerServiceClient {

    @GetMapping("/{id}")
    TripResponse findById(@PathVariable("id") Integer id);
}
