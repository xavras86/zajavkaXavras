package pl.xavras.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.xavras.domain.Restaurant;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemDTO {

    String name;
    BigDecimal price;
    String category;
    String description;
    Restaurant restaurant;

}
