package pl.xavras.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.xavras.business.dao.RestaurantDAO;
import pl.xavras.domain.MenuItem;
import pl.xavras.domain.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class RestaurantService {

    private final RestaurantDAO restaurantDAO;

    public List<Restaurant> findAll() {
        return restaurantDAO.findAll();
    }

    public Set<Restaurant> findRestaurantsByStreetName(String streetName) {
        return restaurantDAO.findRestaurantsByStreetName(streetName);
    }

    public Optional<Restaurant> findByName(String restaurantName) {
        return restaurantDAO.findByName(restaurantName);
    }
}
