package springframework.yemektarifleri.yemek_tariflerid_eneme.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Recipe;
import springframework.yemektarifleri.yemek_tariflerid_eneme.services.RecipeService;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/recipeAll")
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


}
