package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.xavras.api.dto.AddressDTO;
import pl.xavras.api.dto.MenuItemDTO;
import pl.xavras.domain.Address;
import pl.xavras.domain.MenuItem;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    MenuItemDTO map(MenuItem menuItem);
}
