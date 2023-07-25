package pl.xavras.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.xavras.infrastructure.database.entity.CustomerEntity;

import java.util.List;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Integer> {

    List<CustomerEntity> findAll();


}
