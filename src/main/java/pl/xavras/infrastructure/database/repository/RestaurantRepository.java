package pl.xavras.infrastructure.database.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.xavras.domain.Restaurant;
import pl.xavras.infrastructure.database.entity.dao.RestaurantDAO;
import pl.xavras.infrastructure.database.repository.jpa.RestaurantJpaRepository;
import pl.xavras.infrastructure.database.repository.mapper.RestaurantEntityMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RestaurantRepository implements RestaurantDAO {

    private final RestaurantJpaRepository restaurantJpaRepository;
    private final RestaurantEntityMapper restaurantEntityMapper;
    private final StreetRepository streetRepository;


    @Override
    public Optional<Restaurant> findByName(String name) {
        return restaurantJpaRepository.findByName(name)
                .map(restaurantEntityMapper::mapFromEntity);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantJpaRepository.findAll().stream()
                .map(restaurantEntityMapper::mapFromEntity).toList();
    }

    @Override
    public Set<Restaurant> findRestaurantsByStreetName(String streetName) {
        var street = streetRepository.findByStreet(streetName)
                .orElseThrow(() -> new RuntimeException("wrong street name [%s]".formatted(streetName)));
        return street.getRestaurantStreets().stream().map(a -> a.getRestaurant())
                .map(restaurantEntityMapper::mapFromEntity)
                .collect(Collectors.toSet());
    }


}
