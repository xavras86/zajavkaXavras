package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.xavras.api.dto.StreetDTO;
import pl.xavras.domain.Street;

@Mapper(componentModel = "spring")
public interface StreetMapper {

    StreetDTO map(Street street);


}
