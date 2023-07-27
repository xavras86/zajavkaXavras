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
import pl.xavras.infrastructure.database.repository.mapper.AddressEntityMapper;
import pl.xavras.infrastructure.database.repository.mapper.CustomerEntityMapper;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    private final OrderDAO orderDAO;

    private final CustomerEntityMapper customerEntityMapper;
    private final AddressEntityMapper addressEntityMapper;

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

    private Order buildOrder(Customer customer, Address address, Set<MenuItemOrder> menuItemOrders
            //todo powinno być zalezne od restauracji - zamowienie tylko z jednej restauracji, czy tzeba tutaj uwzglednic ?
    ) {
        OffsetDateTime whenCreated = OffsetDateTime.now();
        return Order.builder()
                .orderNumber(generateOrderNumber(whenCreated))
                .receivedDateTime(whenCreated)
                .completedDateTime(null)
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