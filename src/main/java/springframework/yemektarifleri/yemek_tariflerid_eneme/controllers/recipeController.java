package springframework.yemektarifleri.yemek_tariflerid_eneme.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springframework.yemektarifleri.yemek_tariflerid_eneme.exceptions.NotFoundException;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Recipe;
import springframework.yemektarifleri.yemek_tariflerid_eneme.services.RecipeService;

import javax.validation.Valid;

@Controller
public class recipeController {

    private final RecipeService recipeService;

    public recipeController(RecipeService recipeService) {

        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/recipeDetail")
    public String getRecipeDetail(@PathVariable String id, Model model) {
        Recipe recipe = this.recipeService.findById(new Long(id));
        model.addAttribute(recipe);
        return "recipies/recipeDetail";
    }

    @GetMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new Recipe());

        return "recipies/recipeUpdateAndCreate";
    }

    @GetMapping("recipe/{id}/edit")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return  "recipies/recipeUpdateAndCreate";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult result){

        if (result.hasErrors()){
            return "recipies/recipeUpdateAndCreate";
        }

        Recipe savedRecipe = recipeService.save(recipe);

        return "redirect:/recipe/" + savedRecipe.getId() + "/recipeDetail";
    }

    @GetMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id){
        recipeService.deletById(Long.valueOf(id));
        return "redirect:/";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormatFound(Exception exception){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("400error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

}

