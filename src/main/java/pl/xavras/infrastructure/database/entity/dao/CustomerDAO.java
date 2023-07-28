package pl.xavras.infrastructure.database.entity.dao;

import pl.xavras.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    Optional<Customer> findByLogin(String login);

    List<Customer> findAll();


    Customer saveCustomer(Customer customer);


    Optional<Customer> findByEmail(String email);
}
