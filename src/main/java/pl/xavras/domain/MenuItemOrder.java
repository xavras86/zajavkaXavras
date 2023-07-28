package pl.xavras.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.With;
import pl.xavras.infrastructure.database.entity.MenuItemEntity;
import pl.xavras.infrastructure.database.entity.OrderEntity;

@With
@Value
@Builder
@Data
public class MenuItemOrder {

    Integer menuItemOrdersId;
    Integer quantity;
    MenuItemEntity menuItem;
    OrderEntity order;
}
