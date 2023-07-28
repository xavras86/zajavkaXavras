package pl.xavras.infrastructure.database.entity.dao;

import pl.xavras.domain.Address;
import pl.xavras.domain.MenuItemOrder;
import pl.xavras.domain.Order;

import java.util.Set;

public interface MenuItemOrderDAO {

    Set<MenuItemOrder> findByOrderNumber(Order order);

}
