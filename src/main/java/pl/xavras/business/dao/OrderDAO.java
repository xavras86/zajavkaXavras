package pl.xavras.business.dao;

import pl.xavras.domain.Order;

import java.util.List;

public interface OrderDAO {

    List<Order> findAll();
}