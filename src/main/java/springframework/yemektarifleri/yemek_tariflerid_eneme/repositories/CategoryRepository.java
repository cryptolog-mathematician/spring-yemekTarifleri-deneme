package springframework.yemektarifleri.yemek_tariflerid_eneme.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
