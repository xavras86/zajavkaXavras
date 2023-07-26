package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.xavras.api.dto.MenuItemDTO;
import pl.xavras.api.dto.RestaurantDTO;
import pl.xavras.domain.MenuItem;
import pl.xavras.domain.Restaurant;
import pl.xavras.infrastructure.database.entity.MenuItemEntity;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    @Mapping(source = "menuItems", target = "menuItems", qualifiedByName = "mapMenuItems")
    RestaurantDTO map(Restaurant restaurant);

    @Named("mapMenuItems")
    default Set<MenuItemDTO> mapMenuItems(Set<MenuItem> menuItems) {
        return menuItems.stream().map(this::map).collect(Collectors.toSet());
    }

    MenuItemDTO map (MenuItem entity);
}
