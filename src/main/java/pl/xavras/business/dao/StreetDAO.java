package pl.xavras.business.dao;

import pl.xavras.domain.Street;

import java.util.List;

public interface StreetDAO {
   List<Street> findAll();
}
