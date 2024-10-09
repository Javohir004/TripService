package uz.tripshare.tripservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.tripshare.domain.common.Address;
import uz.tripshare.tripservice.domain.Dto.Request.AddressRequest;
import uz.tripshare.tripservice.service.address.AddressServiceImpl;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressServiceImpl addressService;

    @PostMapping("/save")
    public Address save(@RequestBody AddressRequest addressRequest) {
        return addressService.save(addressRequest);
    }

    @PatchMapping("/{id}")
    public Address update(@PathVariable("id") Integer id, @RequestBody AddressRequest addressRequest) {
        return addressService.update(id, addressRequest);

    }

}
