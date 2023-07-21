package pl.xavras.business.dao;

import pl.xavras.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantDAO {

    Optional<Restaurant> findByName(String name);

    List<Restaurant> findAll();
}
