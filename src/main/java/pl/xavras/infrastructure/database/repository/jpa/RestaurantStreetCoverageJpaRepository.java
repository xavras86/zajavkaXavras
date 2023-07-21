package pl.xavras.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.xavras.infrastructure.database.entity.RestaurantStreetCoverageEntity;

public interface RestaurantStreetCoverageJpaRepository extends JpaRepository<RestaurantStreetCoverageEntity, Integer> {
}
