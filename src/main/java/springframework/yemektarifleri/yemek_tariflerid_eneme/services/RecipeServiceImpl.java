package springframework.yemektarifleri.yemek_tariflerid_eneme.services;

import org.springframework.stereotype.Service;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.mapper.RecipeMapper;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model.RecipeDTO;
import springframework.yemektarifleri.yemek_tariflerid_eneme.exceptions.NotFoundException;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Recipe;
import springframework.yemektarifleri.yemek_tariflerid_eneme.repositories.RecipeRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;
    private RecipeMapper recipeMapper;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {

        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public RecipeDTO findById(Long aLong) {
        Optional<Recipe> recipe = recipeRepository.findById(aLong);

        if (!recipe.isPresent()){
            throw new NotFoundException("Recipe Not Found. For ID value: " + aLong.toString() );
        }
        return recipeMapper.recipe2recipeDTO(recipe.get());
    }

    @Override
    public Set<RecipeDTO> findAll() {
        Set<RecipeDTO> recipeDTOSet = recipeRepository.findAll()
                                        .stream()
                                        .map(recipe -> recipeMapper.recipe2recipeDTO(recipe))
                                        .collect(Collectors.toSet());

        if (recipeDTOSet.isEmpty()){
            throw new NotFoundException("Recipes Not Found.");
        }
        return recipeDTOSet;
    }

    @Override
    public RecipeDTO save(RecipeDTO object) {
        Recipe recipe = recipeRepository.save(recipeMapper.recipeDTO2recipe(object));

        RecipeDTO recipeDTO= recipeMapper.recipe2recipeDTO(recipe);
        return recipeDTO;
    }

    @Override
    public RecipeDTO saveRecipe(RecipeDTO obj, Long id) {
        Recipe recipe = recipeRepository.save(recipeMapper.recipeDTO2recipe(obj));
        recipe.setId(id); //gereksiz bu aslinda
        RecipeDTO recipeDTO= recipeMapper.recipe2recipeDTO(recipe);
        return recipeDTO;
    }

    @Override
    public void delete(RecipeDTO object) {
        recipeRepository.deleteById(object.getId());
    }

    @Override
    public void deletById(Long aLong) {
        recipeRepository.deleteById(aLong);
    }
}
