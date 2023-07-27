package pl.xavras.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.With;
import pl.xavras.infrastructure.database.entity.AddressEntity;
import pl.xavras.infrastructure.database.entity.CustomerEntity;
import pl.xavras.infrastructure.database.entity.MenuItemOrderEntity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

@With
@Value
@Builder
@Data
public class Order {

    String order_number;

    OffsetDateTime receivedDateTime;

    OffsetDateTime completedDateTime;

    Boolean isCancelled;

    Boolean isCompleted;

    BigDecimal totalValue;

    CustomerEntity customer;

    AddressEntity address;

    Set<MenuItemOrderEntity> menuItemOrders;
}
