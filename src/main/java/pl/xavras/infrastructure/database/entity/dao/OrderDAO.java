package pl.xavras.infrastructure.database.entity.dao;

import pl.xavras.domain.Order;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface OrderDAO {

    List<Order> findAll();

    Set<Order> findOrdersByCustomerEmail(String customerEmail);

    Optional<Order> findByOrderNumber(String orderNumber);

    Order saveOrder(Order order);




}