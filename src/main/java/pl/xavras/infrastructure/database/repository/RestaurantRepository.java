package pl.xavras.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.xavras.business.dao.RestaurantDAO;
import pl.xavras.domain.Restaurant;
import pl.xavras.infrastructure.database.repository.jpa.RestaurantJpaRepository;
import pl.xavras.infrastructure.database.repository.mapper.RestaurantEntityMapper;

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

    public List<Restaurant> findAll(){
        return restaurantJpaRepository.findAll().stream()
                .map(restaurantEntityMapper::mapFromEntity).toList();
    }
}
