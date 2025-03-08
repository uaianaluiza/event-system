package com.event.system.v2.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public Address getAddress(@PathVariable String cep) {
        return addressService.getAddress(cep);
    }
}
