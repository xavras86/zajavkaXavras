package pl.xavras.infrastructure.database.entity.dao;

import pl.xavras.domain.Address;

public interface AddressDAO {
    Address saveAddress(Address address);

}
