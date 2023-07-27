package pl.xavras.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.xavras.api.dto.CustomerDTO;
import pl.xavras.api.dto.OrderDTO;
import pl.xavras.api.dto.mapper.CustomerMapper;
import pl.xavras.api.dto.mapper.OrderMapper;
import pl.xavras.api.dto.mapper.StreetMapper;
import pl.xavras.business.OrderService;
import pl.xavras.business.StreetService;
import pl.xavras.domain.Order;
import pl.xavras.infrastructure.database.entity.CustomerEntity;

import java.util.List;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
@Slf4j
public class OrderController {

    public static final String ORDERS = "/orders";
    private final OrderService orderService;
    private  final OrderMapper orderMapper;
    private  final CustomerMapper customerMapper;


    @GetMapping(ORDERS)
    public String orders(Model model) {
        var allOrders = orderService.findAll().stream().map(orderMapper::map);

        model.addAttribute("orders", allOrders);

        return "orders";
    }
}

