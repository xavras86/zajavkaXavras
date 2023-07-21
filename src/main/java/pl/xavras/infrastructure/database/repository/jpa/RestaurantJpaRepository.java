package pl.xavras.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.xavras.infrastructure.database.entity.RestaurantEntity;

import java.util.List;
import java.util.Optional;
@Repository
public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity, Integer> {
    Optional<RestaurantEntity> findByName(String name);

    List<RestaurantEntity> findAll();
}
