package pl.xavras.infrastructure.database.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.xavras.business.dao.OrderDAO;
import pl.xavras.business.dao.StreetDAO;
import pl.xavras.domain.Order;
import pl.xavras.domain.Street;
import pl.xavras.infrastructure.database.repository.jpa.OrderJpaRepository;
import pl.xavras.infrastructure.database.repository.jpa.StreetJpaRepository;
import pl.xavras.infrastructure.database.repository.mapper.OrderEntityMapper;
import pl.xavras.infrastructure.database.repository.mapper.StreetEntityMapper;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepository implements OrderDAO {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderEntityMapper orderEntityMapper;


    @Override
    public List<Order> findAll() {
        return orderJpaRepository.findAll().stream()
                .map(orderEntityMapper::mapFromEntity).toList();
    }



}
