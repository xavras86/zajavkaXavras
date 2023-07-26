package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.xavras.api.dto.CustomerDTO;
import pl.xavras.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO map(Customer customer);

    Customer map(CustomerDTO customerDTO);
}
