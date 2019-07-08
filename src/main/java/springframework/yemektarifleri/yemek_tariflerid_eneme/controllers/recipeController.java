package springframework.yemektarifleri.yemek_tariflerid_eneme.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Recipe;
import springframework.yemektarifleri.yemek_tariflerid_eneme.services.RecipeService;

@Controller
public class recipeController {

    private final RecipeService recipeService;

    public recipeController(RecipeService recipeService) {

        this.recipeService = recipeService;
    }

    @RequestMapping("/recipes")
    public  String findAllRecipe(Model model){
        model.addAttribute("recipes", recipeService.findAll());
        return "recipeHome";
    }

    @GetMapping("/recipes/{recipeId}/edit")
    public String initUpdateOwnerForm(@PathVariable("recipeId") Long recipeId, Model model) {
        Recipe recipe = this.recipeService.findById(recipeId);
        model.addAttribute(recipe);
        return "recipeUpdateAndCreate";
    }

    @PostMapping("/recipes/{recipeId}/edit")
    public String processUpdateOwnerForm(Recipe recipe, BindingResult result, @PathVariable("recipeId") Long recipeId) {
        if (result.hasErrors()) {
            return "recipeUpdateAndCreate";
        } else {
            this.recipeService.save(recipe);
            return "/recipes/{recipeId}";
        }
    }
}

