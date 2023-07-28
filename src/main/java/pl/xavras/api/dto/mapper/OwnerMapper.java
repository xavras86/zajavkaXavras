package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.xavras.api.dto.OwnerDTO;
import pl.xavras.domain.Owner;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerDTO map(Owner owner);
}
