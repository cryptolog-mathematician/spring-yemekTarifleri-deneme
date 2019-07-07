package springframework.yemektarifleri.yemek_tariflerid_eneme.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.UnitOfMeasure;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
