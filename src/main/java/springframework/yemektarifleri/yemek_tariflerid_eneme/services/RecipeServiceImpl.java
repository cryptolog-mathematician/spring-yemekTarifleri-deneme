package springframework.yemektarifleri.yemek_tariflerid_eneme.services;

import org.springframework.stereotype.Service;
import springframework.yemektarifleri.yemek_tariflerid_eneme.exceptions.NotFoundException;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Recipe;
import springframework.yemektarifleri.yemek_tariflerid_eneme.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {

        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe findById(Long aLong) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(aLong);

        if (!recipeOptional.isPresent()) {
            throw new NotFoundException("Recipe Not Found. For ID value: " + aLong.toString() );
        }

        return recipeOptional.get();
    }

    @Override
    public Set<Recipe> findAll() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Recipe save(Recipe object) {
        return recipeRepository.save(object);
    }

    @Override
    public void delete(Recipe object) {
        recipeRepository.delete(object);
    }

    @Override
    public void deletById(Long aLong) {
        recipeRepository.deleteById(aLong);
    }
}
