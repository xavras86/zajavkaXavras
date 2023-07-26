package pl.xavras.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.xavras.domain.Address;
import pl.xavras.domain.Customer;
import pl.xavras.infrastructure.database.entity.AddressEntity;
import pl.xavras.infrastructure.database.entity.CustomerEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressEntityMapper {


     Address mapFromEntity(AddressEntity entity);

}
