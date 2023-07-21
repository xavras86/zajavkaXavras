package pl.xavras.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.xavras.infrastructure.database.entity.StreetCoverageEntity;

public interface StreetCoverageJpaRepository extends JpaRepository<StreetCoverageEntity, Integer> {
}
