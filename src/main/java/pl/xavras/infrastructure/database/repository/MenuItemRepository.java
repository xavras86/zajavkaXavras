package pl.xavras.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.xavras.domain.MenuItem;
import pl.xavras.infrastructure.database.entity.dao.MenuItemDAO;
import pl.xavras.infrastructure.database.repository.jpa.MenuItemJpaRepository;
import pl.xavras.infrastructure.database.repository.mapper.MenuItemEntityMapper;

import java.util.List;

@Repository
@AllArgsConstructor
public class MenuItemRepository implements MenuItemDAO {

    private final MenuItemJpaRepository menuItemJpaRepository;

    private final MenuItemEntityMapper menuItemMapper;


    @Override
    public List<MenuItem> findAll(){
        return menuItemJpaRepository.findAll().stream()
                .map(menuItemMapper::mapFromEntity).toList();
    }

//    @Override
//    public Customer saveCustomer(Customer customer) {
//        CustomerEntity toSave = customerEntityMapper.mapToEntity(customer);
//        CustomerEntity saved = customerJpaRepository.save(toSave);
//        return customerEntityMapper.mapFromEntity(saved);
//    }
}
