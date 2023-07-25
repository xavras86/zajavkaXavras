package pl.xavras.business.dao;

import pl.xavras.domain.Restaurant;
import pl.xavras.domain.Street;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StreetDAO {
   List<Street> findAll();

   Optional<Street> findByStreet(String street);

   //
//    Set<Street> findStreetsByRestaurantName(String name);

}
