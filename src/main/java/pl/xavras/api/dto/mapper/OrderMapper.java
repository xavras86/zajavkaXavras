package pl.xavras.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.xavras.api.dto.CustomerAddressOrderDTO;
import pl.xavras.api.dto.OrderDTO;
import pl.xavras.domain.Address;
import pl.xavras.domain.Customer;
import pl.xavras.domain.Order;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper extends OffsetDateTimeMapper {

    @Mapping(source = "receivedDateTime", target = "receivedDateTime", qualifiedByName = "mapOffsetDateTimeToString")
    @Mapping(source = "completedDateTime", target = "completedDateTime", qualifiedByName = "mapOffsetDateTimeToString")
    OrderDTO map(Order order);


    default Order map(CustomerAddressOrderDTO dto) {

        return Order.builder()
                .customer(Customer.builder() //todo customer na pdostawie zalogowanego uzytkownika
                        .name(dto.getName())
                        .surname(dto.getSurname())
                        .phone(dto.getPhone())
                        .email(dto.getEmail())
                        .login(dto.getLogin())
                        .build())
                .address(Address.builder()
                        .country(dto.getCountry())
                        .city(dto.getCity())
                        .street(dto.getStreet())
                        .buildingNumber(dto.getBuildingNumber())
                        .build())
                .build();
    }

}
