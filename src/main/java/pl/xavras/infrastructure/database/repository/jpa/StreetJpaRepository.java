package pl.xavras.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.xavras.infrastructure.database.entity.StreetEntity;

import java.util.List;

public interface StreetJpaRepository extends JpaRepository<StreetEntity, Integer> {

    List<StreetEntity> findAll();
}
