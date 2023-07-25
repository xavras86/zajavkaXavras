package pl.xavras.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.xavras.api.dto.CustomerDTO;
import pl.xavras.api.dto.mapper.CustomerMapper;
import pl.xavras.business.CustomerService;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class CustomerController {

    public static final String CUSTOMERS = "/customers";
    public static final String CUSTOMER_BY_LOGIN = "/customer/show/{login}";

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping(CUSTOMERS)
    public String customers(Model model) {
        List<CustomerDTO> allCustomers = customerService.findAll().stream()
                .map(customerMapper::map).toList();
        model.addAttribute("customers", allCustomers);
        return "customers";
    }

    @GetMapping(CUSTOMER_BY_LOGIN)
    public String showCustomerDetails(@PathVariable String login, Model model) {

        CustomerDTO customerDetails = customerService.findByLogin(login)
                .map(customerMapper::map)
                .orElseThrow(() -> new RuntimeException("Customer with login [%s] doest noc exists".formatted(login)));

        model.addAttribute("customer", customerDetails);

        return "customerDetails";
    }
}

