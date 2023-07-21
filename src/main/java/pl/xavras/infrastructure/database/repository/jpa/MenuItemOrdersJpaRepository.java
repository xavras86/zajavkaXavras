package pl.xavras.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.xavras.infrastructure.database.entity.MenuItemOrderEntity;

public interface MenuItemOrdersJpaRepository extends JpaRepository<MenuItemOrderEntity, Integer> {
}
