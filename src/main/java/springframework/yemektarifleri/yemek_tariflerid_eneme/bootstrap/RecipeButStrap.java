package springframework.yemektarifleri.yemek_tariflerid_eneme.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Notes;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Recipe;
import springframework.yemektarifleri.yemek_tariflerid_eneme.repositories.RecipeRepository;

import java.util.ArrayList;
import java.util.List;


@Component
public class RecipeButStrap implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;

    public RecipeButStrap(RecipeRepository recipeRepository) {

        this.recipeRepository = recipeRepository;
    }

    @Override
    //@Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //recipeRepository.saveAll(getRecipes());
       // log.debug("Loading Bootstrap Data");
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>();

        Recipe recipe1 = new Recipe();
        recipe1.setDescription("Lahmacun");
        recipe1.setCookTime("15 minute");
        recipe1.setPrepTime("30 minute");
        recipe1.setDirections(" It should serve as a flat round piece of bread served with minced meat or vegetables, as well as herbs, parsley onion, and tomatoes.");
        //recipe1.setImege("");
        recipe1.setServings("10");
        recipe1.setSource("xxxxx");

        Notes notes = new Notes();
        notes.setRecipeNotes("Be careful");
        recipe1.setNotes(notes);

        recipes.add(recipe1);

        return recipes;
    }

}
