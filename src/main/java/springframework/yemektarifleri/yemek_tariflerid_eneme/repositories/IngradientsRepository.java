package springframework.yemektarifleri.yemek_tariflerid_eneme.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Ingradients;

@Repository
public interface IngradientsRepository extends CrudRepository<Ingradients, Long> {
}
