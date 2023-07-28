package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.xavras.api.dto.MenuItemDTO;
import pl.xavras.domain.MenuItem;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    MenuItemDTO map(MenuItem menuItem);
    Set<MenuItemDTO> map(Set<MenuItem> menuItem);
}
