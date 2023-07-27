package pl.xavras.infrastructure.database.entity.dao;

import pl.xavras.domain.MenuItem;

import java.util.List;

public interface MenuItemDAO {

    List<MenuItem> findAll();

}
