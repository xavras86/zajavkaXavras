package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.xavras.api.dto.RestaurantDTO;
import pl.xavras.domain.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    RestaurantDTO mapFromEntity(Restaurant restaurant);
}
