package pl.xavras.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.xavras.business.dao.CustomerDAO;
import pl.xavras.domain.Customer;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerDAO customerDAO;

    @Transactional
    public List<Customer> findAll() {

        return customerDAO.findAll();
    }

    @Transactional
    public Optional<Customer> findByLogin(String login) {
        Optional<Customer> byLogin = customerDAO.findByLogin(login);
        if (byLogin.isEmpty()) {
            throw new RuntimeException("Customer with login [%s] doest noc exists".formatted(login));
        }
        return byLogin;
    }
    @Transactional
    public Customer saveCustomer(Customer customer){
        return customerDAO.saveCustomer(customer);
    }
}