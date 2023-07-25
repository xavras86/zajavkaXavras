package pl.xavras.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.xavras.infrastructure.database.entity.RestaurantStreetEntity;

public interface RestaurantStreetJpaRepository extends JpaRepository<RestaurantStreetEntity, Integer> {
}
