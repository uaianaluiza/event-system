package com.event.system.v2.address;

import com.event.system.v2.exceptions.CepNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressClient addressClient;

    public AddressService(AddressClient addressClient) {
        this.addressClient = addressClient;
    }

    public Address getAddress(String cep) {
        try {
            return addressClient.getAddress(cep);
        } catch (CepNotFoundException e) {
            throw new CepNotFoundException("Cep not found");
        }
    }
}
