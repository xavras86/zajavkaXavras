package pl.xavras.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.xavras.domain.Address;
import pl.xavras.infrastructure.database.entity.dao.AddressDAO;

@Service
@AllArgsConstructor
@Slf4j
public class AddressService {

    private final AddressDAO addressDAO;


    @Transactional
    public Address saveAddress(Address address) {
        return addressDAO.saveAddress(address);
    }
}