package pl.xavras.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.xavras.business.dao.RestaurantDAO;
import pl.xavras.domain.Restaurant;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RestaurantService {

    private final RestaurantDAO restaurantDAO;

    @Transactional
    public List<Restaurant> findAll() {

        List<Restaurant> all = restaurantDAO.findAll();
        log.info("RESTAUTANTS from SERVICE: " +all);
        return all;

    }
}
