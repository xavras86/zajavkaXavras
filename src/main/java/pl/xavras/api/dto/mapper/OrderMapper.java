package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.xavras.api.dto.AddressDTO;
import pl.xavras.api.dto.OrderDTO;
import pl.xavras.domain.Address;
import pl.xavras.domain.Order;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderDTO map(Order order);
}
