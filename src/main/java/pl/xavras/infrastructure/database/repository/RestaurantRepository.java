package pl.xavras.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import pl.xavras.domain.Restaurant;


import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RestaurantRepository implements RestaurantDAO {

    private final RestaurantJpaRepository restaurantJpaRepository;

    private final RestaurantEntityMapper restaurantEntityMapper;


    @Override
    public Optional<Restaurant> findByName(String name) {
        return restaurantJpaRepository.findByName(name)
                .map(restaurantEntityMapper::mapFromEntity);
    }
    @Override
    public List<Restaurant> findAll(){
        return restaurantJpaRepository.findAll().stream()
                .map(restaurantEntityMapper::mapFromEntity).toList();
    }
//    @Override
//    public Set<Restaurant> findRestaurantsByStreetName(String streetName){
//        return restaurantJpaRepository.findRestaurantsByStreetName(streetName).stream()
//                .map(restaurantEntityMapper::mapFromEntity).collect(Collectors.toSet());
//    }
}
