package springframework.yemektarifleri.yemek_tariflerid_eneme.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.yemektarifleri.yemek_tariflerid_eneme.services.RecipeService;


@Controller
public class indexController {

    private final RecipeService recipeService;

    public indexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/recipes"})
    public String getAllRecipe(Model model){
        //log.debug("Getting recipeHome page");

        model.addAttribute("recipes", recipeService.findAll());
        return "recipeHome";
    }
}
