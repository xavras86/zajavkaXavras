package pl.xavras.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.xavras.domain.Address;
import pl.xavras.domain.Customer;
import pl.xavras.domain.MenuItemOrder;
import pl.xavras.domain.Order;
import pl.xavras.domain.exception.NotFoundException;
import pl.xavras.infrastructure.database.entity.dao.OrderDAO;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    private final OrderDAO orderDAO;


    private final CustomerService customerService;
    private final AddressService addressService;

    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    public Set<Order> findByCustomerEmail(String email) {
        return orderDAO.findOrdersByCustomerEmail(email);
        //todo pusty set ?
    }

    public Optional<Order> findByOrderNumber(String orderNumber) {
        Optional<Order> byOrderNumber = orderDAO.findByOrderNumber(orderNumber);
        if (byOrderNumber.isEmpty()) {
            throw new NotFoundException("Could not find order with orderNumber: [%s]".formatted(orderNumber));
        }
        return byOrderNumber;
    }




    public void placeOrder(Order order){
        Customer customer = customerService.findByEmail(order.getCustomer().getEmail());
        Address address = addressService.saveAddress(order.getAddress());
        Set<MenuItemOrder> menuItemOrders = new HashSet<>(); //todo dodac liste pozycji
        Order orderToPlace = buildOrder(customer, address, menuItemOrders);
        orderDAO.saveOrder(orderToPlace);

    }


    private Order buildOrder(Customer customer, Address address, Set<MenuItemOrder> menuItemOrders
            //todo powinno być zalezne od restauracji - zamowienie tylko z jednej restauracji, czy tzeba tutaj uwzglednic ?
    ) {
        OffsetDateTime whenCreated = OffsetDateTime.now();
        return Order.builder()
                .orderNumber(generateOrderNumber(whenCreated))
                .receivedDateTime(whenCreated)
                .completedDateTime(whenCreated)
                .totalValue(calculateTotalOrderValue(menuItemOrders))
                .menuItemOrders(menuItemOrders)
                .customer(customer)
                .address(address)
                .build();

    }

    private BigDecimal calculateTotalOrderValue(Set<MenuItemOrder> menuItemOrders){
        return menuItemOrders.stream()
                .map(this::calculateOrderEntryValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
    private BigDecimal calculateOrderEntryValue(MenuItemOrder menuItemOrder){
        return menuItemOrder.getMenuItem().getPrice()
                .multiply(new BigDecimal(menuItemOrder.getQuantity()));
    }


    private String generateOrderNumber(OffsetDateTime when) {
        return "%s.%s.%s-%s.%s.%s.%s".formatted(
                when.getYear(),
                when.getMonth().ordinal(),
                when.getDayOfMonth(),
                when.getHour(),
                when.getMinute(),
                when.getSecond(),
                (new Random().nextInt(90) + 10)
        );
    }



}