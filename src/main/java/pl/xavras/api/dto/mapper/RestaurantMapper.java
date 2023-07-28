package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.xavras.api.dto.RestaurantDTO;
import pl.xavras.domain.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

//    @Mapping(source = "menuItems", target = "menuItems", qualifiedByName = "mapMenuItems")

    RestaurantDTO map(Restaurant restaurant);

//    @Named("mapMenuItems")
//    default Set<MenuItemDTO> mapMenuItems(Set<MenuItem> menuItems) {
//        return menuItems.stream().map(this::map).collect(Collectors.toSet());
//    }

//    MenuItemDTO map (MenuItem entity);
}
