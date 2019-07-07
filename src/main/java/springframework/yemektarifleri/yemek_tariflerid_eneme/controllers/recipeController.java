package springframework.yemektarifleri.yemek_tariflerid_eneme.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.yemektarifleri.yemek_tariflerid_eneme.services.RecipeService;

@Controller
public class recipeController {

    private final RecipeService recipeService;

    public recipeController(RecipeService recipeService) {

        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipies", "/recipiesHome", "/recipieshome"})
    public  String findAllRecipe(Model model){
        model.addAttribute("recipes", recipeService.findAll());
        return "recipeHome";
    }
}

