package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.xavras.api.dto.AddressDTO;
import pl.xavras.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO map(Address address);
}
