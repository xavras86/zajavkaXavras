package pl.xavras.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.xavras.infrastructure.database.entity.MenuItemEntity;

public interface MenuItemJpaRepository extends JpaRepository<MenuItemEntity, Integer> {
}
