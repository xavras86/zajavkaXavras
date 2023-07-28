package pl.xavras.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.xavras.domain.Address;
import pl.xavras.infrastructure.database.entity.AddressEntity;
import pl.xavras.infrastructure.database.entity.dao.AddressDAO;
import pl.xavras.infrastructure.database.repository.jpa.AddressJpaRepository;
import pl.xavras.infrastructure.database.repository.mapper.AddressEntityMapper;


@Repository
@AllArgsConstructor
public class AddressRepository implements AddressDAO {

    private final AddressJpaRepository addressJpaRepository;

    private final AddressEntityMapper addressEntityMapper;

    @Override
    public Address saveAddress(Address address) {
        AddressEntity toSave = addressEntityMapper.mapToEntity(address);
        AddressEntity saved = addressJpaRepository.save(toSave);
        return addressEntityMapper.mapFromEntity(saved);
    }
}
