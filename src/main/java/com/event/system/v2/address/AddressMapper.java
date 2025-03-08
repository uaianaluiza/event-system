package com.event.system.v2.address;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressResponseDto toAddressResponseDto(Address address);

    @Mapping(source = "cep", target = "cep")
    @Mapping(source = "street", target = "street")
    @Mapping(source = "complement", target = "complement")
    @Mapping(source = "unit", target = "unit")
    @Mapping(source = "neighborhood", target = "neighborhood")
    @Mapping(source = "locality", target = "locality")
    @Mapping(source = "uf", target = "uf")
    @Mapping(source = "state", target = "state")
    @Mapping(source = "region", target = "region")
    Address fromAddressDto(AddressResponseDto addressDto);
}
