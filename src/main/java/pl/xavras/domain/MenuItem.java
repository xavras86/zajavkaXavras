package pl.xavras.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.With;

import java.math.BigDecimal;

@With
@Value
@Builder
@Data
public class MenuItem {

    String name;
    BigDecimal price;
    String category;
    String description;
    Restaurant restaurant;

    //todo dodac set z menuitemorderami

}
