package pl.xavras.domain;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.With;
import pl.xavras.infrastructure.database.entity.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

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
