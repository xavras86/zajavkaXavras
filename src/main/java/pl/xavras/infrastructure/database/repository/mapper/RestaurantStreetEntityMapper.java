package pl.xavras.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.xavras.domain.RestaurantStreet;
import pl.xavras.domain.Street;
import pl.xavras.infrastructure.database.entity.RestaurantStreetEntity;
import pl.xavras.infrastructure.database.entity.StreetEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantStreetEntityMapper {

    RestaurantStreet mapFromEntity(RestaurantStreetEntity entity);
}
