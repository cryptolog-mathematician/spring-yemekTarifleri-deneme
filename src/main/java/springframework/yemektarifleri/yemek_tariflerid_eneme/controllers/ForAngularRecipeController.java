package springframework.yemektarifleri.yemek_tariflerid_eneme.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model.RecipeDTO;
import springframework.yemektarifleri.yemek_tariflerid_eneme.services.RecipeService;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value ="/recipeAll", produces = "application/json")
public class ForAngularRecipeController {

    private final RecipeService recipeService;

    public ForAngularRecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<RecipeDTO> getAllRecipe(){

        return recipeService.findAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public RecipeDTO getRecipeById(@PathVariable Long id){

        return recipeService.findById(id);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public RecipeDTO updateRecipe(@RequestBody RecipeDTO recipe, @PathVariable Long id){

        return recipeService.saveRecipe(recipe, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public RecipeDTO createRecipe(@RequestBody RecipeDTO recipe){

        return recipeService.save(recipe);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteToDo(@PathVariable Long id){

        recipeService.deletById(id);
    }
}
