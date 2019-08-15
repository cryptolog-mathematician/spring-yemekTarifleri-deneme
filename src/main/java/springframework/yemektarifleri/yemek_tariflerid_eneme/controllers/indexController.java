package springframework.yemektarifleri.yemek_tariflerid_eneme.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springframework.yemektarifleri.yemek_tariflerid_eneme.services.RecipeService;



@Controller
public class indexController {

    private final RecipeService recipeService;

    public indexController(RecipeService recipeService) {

        this.recipeService = recipeService;
    }

    @GetMapping({"/recipes"})
    public String getRecipes(Model model){
        model.addAttribute("recipes", recipeService.findAll());
        return "recipies/recipeHome";
    }

}
