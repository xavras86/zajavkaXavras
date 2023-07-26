package pl.xavras.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.xavras.domain.Customer;
import pl.xavras.infrastructure.database.entity.CustomerEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerEntityMapper {


    default Customer mapFromEntity(CustomerEntity entity) {
        return Customer.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .login(entity.getName() + "." + entity.getSurname())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .build();
    }

    default CustomerEntity mapToEntity(Customer customer) {
        return CustomerEntity.builder()
                .name(customer.getName())
                .surname(customer.getSurname())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .build();
    }
}
