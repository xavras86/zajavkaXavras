package pl.xavras.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.xavras.infrastructure.database.entity.OrderEntity;

public interface OrdersJpaRepository extends JpaRepository<OrderEntity, Integer> {
}
