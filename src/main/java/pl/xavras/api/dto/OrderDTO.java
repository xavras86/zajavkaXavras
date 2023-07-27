package pl.xavras.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.xavras.infrastructure.database.entity.AddressEntity;
import pl.xavras.infrastructure.database.entity.CustomerEntity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String orderNumber;
    private OffsetDateTime receivedDateTime;
    private OffsetDateTime completedDateTime;
    private Boolean isCancelled;
    private Boolean isCompleted;
    private BigDecimal totalValue;
    private CustomerEntity customer;
    private AddressEntity address;
}
