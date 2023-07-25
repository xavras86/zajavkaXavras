package pl.xavras.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.xavras.infrastructure.database.entity.RestaurantEntity;

import java.util.List;
import java.util.Optional;
@Repository
public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity, Integer> {
    Optional<RestaurantEntity> findByName(String name);

    List<RestaurantEntity> findAll();

//    @Query("""
//            SELECT restaurant.restaurant_id, restaurant.name, restaurant.phone, restaurant.email FROM restaurant_street AS rsc
//            	JOIN street ON street.street_id = rsc.street_id
//            	JOIN restaurant ON restaurant.restaurant_id = rsc.restaurant_id
//            	WHERE street.street = :streetName;
//                    """)
//    List<RestaurantEntity> findRestaurantsByStreetName(final @Param("streetName")String street);

}
//
//    SELECT restaurant.restaurant_id, restaurant.name, restaurant.phone, restaurant.email FROM restaurant_street rsc
//        INNER JOIN FETCH street ON street.street_id = rsc.street_id
//        INNER JOIN FETCH restaurant ON restaurant.restaurant_id = rsc.restaurant_id
//        WHERE street.street = :streetName;
