package pl.xavras.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.xavras.business.dao.CustomerDAO;
import pl.xavras.domain.Customer;
import pl.xavras.infrastructure.database.entity.CustomerEntity;
import pl.xavras.infrastructure.database.repository.jpa.CustomerJpaRepository;
import pl.xavras.infrastructure.database.repository.mapper.CustomerEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CustomerRepository implements CustomerDAO {

    private final CustomerJpaRepository customerJpaRepository;

    private final CustomerEntityMapper customerEntityMapper;


    @Override
    public Optional<Customer> findByLogin(String login) {
        return findAll().stream()
                .filter(a -> login.equals(a.getLogin()))
                .findFirst();

    }

    @Override
    public List<Customer> findAll(){
        return customerJpaRepository.findAll().stream()
                .map(customerEntityMapper::mapFromEntity).toList();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity toSave = customerEntityMapper.mapToEntity(customer);
        CustomerEntity saved = customerJpaRepository.save(toSave);
        return customerEntityMapper.mapFromEntity(saved);
    }
}
