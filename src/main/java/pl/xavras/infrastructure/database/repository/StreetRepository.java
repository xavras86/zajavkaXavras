package pl.xavras.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.xavras.business.dao.StreetDAO;
import pl.xavras.domain.Street;
import pl.xavras.infrastructure.database.entity.RestaurantEntity;
import pl.xavras.infrastructure.database.entity.RestaurantStreetEntity;
import pl.xavras.infrastructure.database.entity.StreetEntity;
import pl.xavras.infrastructure.database.repository.jpa.StreetJpaRepository;
import pl.xavras.infrastructure.database.repository.mapper.StreetEntityMapper;

import java.util.List;
import java.util.Set;

@Slf4j
@Repository
@AllArgsConstructor
public class StreetRepository implements StreetDAO {

    private final StreetJpaRepository streetJpaRepository;

    private final StreetEntityMapper streetEntityMapper;

    @Override
    public List<Street> findAll() {
//       return streetJpaRepository.findAll().stream()
//                .map(streetEntityMapper::mapFromEntity).toList();

        List<StreetEntity> all = streetJpaRepository.findAll();
        var resturantStreet = all.get(4).getResturantStreet().stream()
                .map(RestaurantStreetEntity::getRestaurant)
                                .toList();
        log.info("<RestaurantStreetEntity-  from repository: "+resturantStreet);
        return  all.stream().map(streetEntityMapper::mapFromEntity).toList();
    }
}
