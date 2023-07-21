package pl.xavras.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.xavras.infrastructure.database.entity.OwnerEntity;

public interface OwnerJpaRepository extends JpaRepository<OwnerEntity, Integer> {
}
