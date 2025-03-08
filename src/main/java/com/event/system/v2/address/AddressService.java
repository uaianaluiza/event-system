package com.event.system.v2.address;

import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressClient addressClient;

    public AddressService(AddressClient addressClient) {
        this.addressClient = addressClient;
    }

    public Address getAddress(String cep) {
        return addressClient.getAddress(cep);
    }
}
