package pl.xavras.business.dao;

import pl.xavras.domain.MenuItem;

import java.util.List;

public interface MenuItemDAO {

    List<MenuItem> findAll();

}
