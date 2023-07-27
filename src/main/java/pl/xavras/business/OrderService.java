package pl.xavras.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.xavras.business.dao.CustomerDAO;
import pl.xavras.business.dao.OrderDAO;
import pl.xavras.domain.Customer;
import pl.xavras.domain.Order;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    private final OrderDAO orderDAO;

    public List<Order> findAll() {
        return orderDAO.findAll();
    }



}