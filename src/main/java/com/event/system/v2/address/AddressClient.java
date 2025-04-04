package com.event.system.v2.address;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface AddressClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json")
    Address getAddress(@PathVariable("cep") String cep);

}
