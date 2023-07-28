package pl.xavras.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.xavras.domain.Customer;
import pl.xavras.domain.exception.NotFoundException;
import pl.xavras.infrastructure.database.entity.dao.CustomerDAO;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerDAO customerDAO;

    public List<Customer> findAll() {

        return customerDAO.findAll();
    }

    public Optional<Customer> findByLogin(String login) {
        Optional<Customer> byLogin = customerDAO.findByLogin(login);
        if (byLogin.isEmpty()) {
            throw new RuntimeException("Customer with login [%s] doest not exists".formatted(login));
        }
        return byLogin;
    }


    public Customer findByEmail(String email) {
        Optional<Customer> customer = customerDAO.findByEmail(email);
        if (customer.isEmpty()) {
            throw new NotFoundException("Could not find customer by email: [%s]".formatted(email));
        }
        return customer.get();
    }


    @Transactional
    public void saveCustomer(Customer customer){
        customerDAO.saveCustomer(customer);
    }
}