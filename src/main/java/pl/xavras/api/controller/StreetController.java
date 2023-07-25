package pl.xavras.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.xavras.api.dto.RestaurantStreetDTO;
import pl.xavras.api.dto.StreetDTO;
import pl.xavras.api.dto.mapper.StreetMapper;
import pl.xavras.business.StreetService;
import pl.xavras.domain.Restaurant;

import java.util.stream.Stream;

@Controller
@AllArgsConstructor
@Slf4j
public class StreetController {

    public static final String STREETS = "/streets";
    public static final String RESTAURANTS_BY_STREET = "/restaurants/show/{street}";

    private final StreetService streetService;

    private final StreetMapper streetMapper;


    @GetMapping(STREETS)
    public String streets(Model model) {
        var allStreets = streetService.findAll().stream()
                .map(streetMapper::map).toList();

        model.addAttribute("streets", allStreets);

//        log.info("streets: " + allStreets);

        return "streets";
    }

//    @GetMapping(CUSTOMER_BY_LOGIN)
//    public String showCustomerDetails(@PathVariable String login, Model model) {
//
//        CustomerDTO customerDetails = customerService.findByLogin(login)
//                .map(customerMapper::map)
//                .orElseThrow(() -> new RuntimeException("Customer with login [%s] doest noc exists".formatted(login)));
//
//        model.addAttribute("customer", customerDetails);
//
//        return "customerDetails";
//    }
}

