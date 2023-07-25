package pl.xavras.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.xavras.domain.Restaurant;
import pl.xavras.infrastructure.database.entity.RestaurantEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantEntityMapper {

    //    @Mapping(target = "address", ignore = true)
//    @Mapping(target = "owner", ignore = true)
//    @Mapping(target = "street", ignore = true)
//    @Mapping(target = "menuItems", ignore = true )
    Restaurant mapFromEntity(RestaurantEntity entity);
}
