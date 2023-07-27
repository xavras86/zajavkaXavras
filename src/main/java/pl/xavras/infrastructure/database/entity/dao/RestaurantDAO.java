package pl.xavras.infrastructure.database.entity.dao;

import pl.xavras.domain.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RestaurantDAO {

    Optional<Restaurant> findByName(String name);

    List<Restaurant> findAll();

    Set<Restaurant> findRestaurantsByStreetName(String streetName);

}
