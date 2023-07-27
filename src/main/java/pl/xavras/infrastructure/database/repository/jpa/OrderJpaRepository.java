package pl.xavras.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.xavras.infrastructure.database.entity.OrderEntity;

import java.util.Optional;
import java.util.Set;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Integer> {

    @Query("""
        SELECT ord FROM OrderEntity ord
        WHERE ord.customer.email = :email
        """)
    Set<OrderEntity> findOrdersByCustomerEmail(final @Param("email") String customerEmail);

    Optional<OrderEntity> findByOrderNumber(String orderNumber);

}
