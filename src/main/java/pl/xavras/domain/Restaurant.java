package pl.xavras.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.With;

import java.util.Set;

@With
@Value
@Builder
@Data
public class Restaurant {

    String name;
    String phone;
    String email;
    Address address;
    Owner owner;
    Set<RestaurantStreet> restaurantStreets;
    Set<MenuItem> menuItems;


}
