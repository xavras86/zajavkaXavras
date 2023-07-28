package pl.xavras.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.xavras.api.dto.CustomerAddressOrderDTO;
import pl.xavras.api.dto.CustomerDTO;
import pl.xavras.api.dto.OrderDTO;
import pl.xavras.api.dto.mapper.CustomerMapper;
import pl.xavras.api.dto.mapper.OrderMapper;
import pl.xavras.business.OrderService;
import pl.xavras.domain.Customer;
import pl.xavras.domain.Order;

@Controller
@AllArgsConstructor
@Slf4j
public class OrderController {

    public static final String ORDERS = "/orders";
    public static final String PLACE_ORDER = "/order/add";
    private final OrderService orderService;
    private  final OrderMapper orderMapper;
    private  final CustomerMapper customerMapper;


    @GetMapping(ORDERS)
    public String orders(Model model) {
        var allOrders = orderService.findAll().stream().map(orderMapper::map);

        model.addAttribute("orders", allOrders);
        model.addAttribute("orderDataDTO", new CustomerAddressOrderDTO());

        return "orders";
    }


    @PostMapping(value = PLACE_ORDER)
    public String placeOrder(
            @Valid @ModelAttribute("orderDataDTO") CustomerAddressOrderDTO customerAddressOrderDTO,
            Model model
    ) {
        Order order = orderMapper.map(customerAddressOrderDTO);

        orderService.placeOrder(order);



        return "order_placed";
    }
}

