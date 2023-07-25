package pl.xavras.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.xavras.domain.Restaurant;
import pl.xavras.domain.Street;
import pl.xavras.infrastructure.database.entity.RestaurantEntity;
import pl.xavras.infrastructure.database.entity.StreetEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantStreetDTO {
    Integer restaurantStreetId;
    Street street;
    Restaurant restaurant;
}
