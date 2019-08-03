package springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model.RecipeDTO;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Recipe;

@Mapper
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDTO recipe2recipeDTO(Recipe recipe);

    Recipe recipeDTO2recipe(RecipeDTO recipeDTO);
}
