package springframework.yemektarifleri.yemek_tariflerid_eneme.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Recipe;
import springframework.yemektarifleri.yemek_tariflerid_eneme.services.RecipeService;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value ="/recipeAll", produces = "application/json")
//@Controller
public class ForAngularController {

    private final RecipeService recipeService;

    public ForAngularController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    //@RequestMapping(value = "/recipesAll", method = RequestMethod.GET, produces = "application/json")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Recipe> getAllRecipe(){

        return recipeService.findAll();
    }

    @GetMapping(value = {"/{id}"}, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Recipe getRecipeById(@PathVariable Long id){

        return recipeService.findById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Recipe updateRecipe(@RequestBody Recipe recipe){

        return recipeService.save(recipe);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe createRecipe(@RequestBody Recipe recipe){

        return recipeService.save(recipe);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteToDo(@PathVariable Long id){

        recipeService.deletById(id);
    }
}
