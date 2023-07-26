package pl.xavras.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.xavras.domain.Address;
import pl.xavras.domain.MenuItem;
import pl.xavras.infrastructure.database.entity.AddressEntity;
import pl.xavras.infrastructure.database.entity.MenuItemEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuItemEntityMapper {


     @Mapping(target = "restaurant", ignore = true)
     MenuItem mapFromEntity(MenuItemEntity entity);

}
