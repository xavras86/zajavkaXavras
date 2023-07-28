package pl.xavras.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import pl.xavras.domain.MenuItem;
import pl.xavras.domain.Restaurant;
import pl.xavras.domain.RestaurantStreet;
import pl.xavras.infrastructure.database.entity.MenuItemEntity;
import pl.xavras.infrastructure.database.entity.RestaurantEntity;
import pl.xavras.infrastructure.database.entity.RestaurantStreetEntity;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantEntityMapper
{

    @Mapping(source = "restaurantStreets", target = "restaurantStreets", qualifiedByName = "mapRestaurantStreets")
    @Mapping(source = "menuItems", target = "menuItems", qualifiedByName = "mapMenuItems")
    Restaurant mapFromEntity (RestaurantEntity entity);

    @Named("mapRestaurantStreets")
    default Set<RestaurantStreet> mapRestaurantStreets(Set<RestaurantStreetEntity> entities) {
        return entities.stream().map(this::mapFromEntity).collect(Collectors.toSet());
    }
    RestaurantStreet mapFromEntity (RestaurantStreetEntity entity);

    @Named("mapMenuItems")
    default Set<MenuItem> mapMenuItems(Set<MenuItemEntity> entities) {
        return entities.stream().map(this::mapFromEntity).collect(Collectors.toSet());
    }

    @Mapping(target = "restaurant", ignore = true)
    MenuItem mapFromEntity (MenuItemEntity entity);


}
