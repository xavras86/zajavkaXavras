package pl.xavras.business.dao;

import pl.xavras.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    Optional<Customer> findByLogin(String login);

    List<Customer> findAll();


}
