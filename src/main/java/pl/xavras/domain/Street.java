package pl.xavras.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.With;
import pl.xavras.infrastructure.database.entity.RestaurantEntity;
import pl.xavras.infrastructure.database.entity.RestaurantStreetEntity;

import java.util.Set;

@With
@Value
@Builder
@Data
public class Street {

    Integer streetId;
    String city;
    String street;
    Set<RestaurantStreet> restaurantStreets;

}
