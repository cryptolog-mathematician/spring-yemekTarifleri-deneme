package springframework.yemektarifleri.yemek_tariflerid_eneme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
