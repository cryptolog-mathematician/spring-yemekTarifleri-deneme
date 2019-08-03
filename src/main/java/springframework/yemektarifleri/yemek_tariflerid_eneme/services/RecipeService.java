package springframework.yemektarifleri.yemek_tariflerid_eneme.services;

import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model.RecipeDTO;

public interface RecipeService extends CrudService<RecipeDTO, Long> {

    RecipeDTO saveRecipe(RecipeDTO obj, Long id);
}
