package pl.xavras.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.xavras.business.dao.StreetDAO;
import pl.xavras.domain.Street;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StreetService {

    private final StreetDAO streetDAO;

    @Transactional
    public List<Street> findAll() {


        List<Street> all = streetDAO.findAll();
//        log.info("streets from SERVICE: " + all);
        log.info("restaurants to streets"+ all.get(0).getRestaurantStreets());
        return all;

    }
}