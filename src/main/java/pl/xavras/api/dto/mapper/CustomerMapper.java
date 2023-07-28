package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.xavras.api.dto.CustomerDTO;
import pl.xavras.domain.Customer;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerDTO map(Customer customer);

    Customer map(CustomerDTO customerDTO);
}
