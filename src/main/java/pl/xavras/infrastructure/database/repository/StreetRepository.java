package pl.xavras.infrastructure.database.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.xavras.infrastructure.database.entity.dao.StreetDAO;
import pl.xavras.domain.Street;
import pl.xavras.infrastructure.database.repository.jpa.StreetJpaRepository;
import pl.xavras.infrastructure.database.repository.mapper.StreetEntityMapper;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class StreetRepository implements StreetDAO {

    private final StreetJpaRepository streetJpaRepository;
    private final StreetEntityMapper streetEntityMapper;


    @Override
    public List<Street> findAll() {
        return streetJpaRepository.findAll().stream()
                .map(streetEntityMapper::mapFromEntity).toList();
    }

    @Override
    public Optional<Street> findByStreet(String street) {
        return streetJpaRepository.findByStreet(street)
                .map(streetEntityMapper::mapFromEntity);
    }

//            ┌─────┐
//           restaurantRepository defined in file [C:\Users\XavrasPC\Desktop\ZAJAVKA_WORKSHOP\23_projekt_koncowy\zajavkaXavras\build\classes\java\main\pl\xavras\infrastructure\database\repository\RestaurantRepository.class]
//            ↑     ↓
//            |  streetRepository defined in file [C:\Users\XavrasPC\Desktop\ZAJAVKA_WORKSHOP\23_projekt_koncowy\zajavkaXavras\build\classes\java\main\pl\xavras\infrastructure\database\repository\StreetRepository.class]
//            └─────┘

//    @Override
//    public Set<Street> findStreetsByRestaurantName(String name) {
//        return restaurantRepository.findByName(name).orElseThrow(() -> new RuntimeException("Wrong street name [%s]".formatted(name)))
//                .getRestaurantStreets().stream().map(a -> a.getStreet())
//                .map(streetEntityMapper::mapFromEntity)
//                .collect(Collectors.toSet());
//    }

}
