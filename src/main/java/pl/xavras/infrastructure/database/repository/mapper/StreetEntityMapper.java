package pl.xavras.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import pl.xavras.domain.RestaurantStreet;
import pl.xavras.domain.Street;
import pl.xavras.infrastructure.database.entity.RestaurantStreetEntity;
import pl.xavras.infrastructure.database.entity.StreetEntity;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StreetEntityMapper {

  @Mapping(source = "restaurantStreets", target = "restaurantStreets", qualifiedByName = "mapRestaurantStreets")
  Street mapFromEntity (StreetEntity entity);

    @Named("mapRestaurantStreets")
    default Set<RestaurantStreet> mapRestaurantStreets(Set<RestaurantStreetEntity> entities) {
        return entities.stream().map(this::mapFromEntity).collect(Collectors.toSet());
    }

    RestaurantStreet mapFromEntity(RestaurantStreetEntity entity);
}



