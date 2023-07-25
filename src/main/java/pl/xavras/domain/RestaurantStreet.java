package pl.xavras.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.With;
import pl.xavras.infrastructure.database.entity.RestaurantEntity;
import pl.xavras.infrastructure.database.entity.StreetEntity;

@With
@Value
@Builder
@Data
public class RestaurantStreet {

    Integer restaurantStreetId;
    StreetEntity street;
    RestaurantEntity restaurant;

}
