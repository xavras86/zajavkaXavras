package pl.xavras.infrastructure.database.entity.dao;

import org.springframework.data.repository.query.Param;
import pl.xavras.domain.Order;
import pl.xavras.infrastructure.database.entity.OrderEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface OrderDAO {

    List<Order> findAll();

    Set<Order> findOrdersByCustomerEmail(String customerEmail);

    Optional<Order> findByOrderNumber(String orderNumber);


}