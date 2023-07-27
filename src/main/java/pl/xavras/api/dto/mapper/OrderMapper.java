package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.xavras.api.dto.AddressDTO;
import pl.xavras.api.dto.OrderDTO;
import pl.xavras.domain.Address;
import pl.xavras.domain.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO map(Order order);
}
