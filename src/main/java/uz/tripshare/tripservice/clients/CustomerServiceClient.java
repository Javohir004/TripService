package uz.tripshare.tripservice.clients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.tripshare.tripservice.config.FeignConfig;
import uz.tripshare.tripservice.domain.Dto.Response.TripResponse;

import java.util.UUID;

@FeignClient(name = "CUSTOMER-SERVICE", configuration = FeignConfig.class /*, url = "http://localhost:8081", path = "/api/customer" */)
public interface CustomerServiceClient {

    @GetMapping("/customer/{id}")
    TripResponse findById(@PathVariable("id") UUID id);
}
