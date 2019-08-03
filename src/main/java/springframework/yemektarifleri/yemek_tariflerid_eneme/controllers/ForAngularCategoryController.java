package springframework.yemektarifleri.yemek_tariflerid_eneme.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model.CategoryDTO;
import springframework.yemektarifleri.yemek_tariflerid_eneme.services.CategoryServiceImpl;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "recipe/categories", produces = "application/json")
public class ForAngularCategoryController {

    private CategoryServiceImpl categoryService;

    public ForAngularCategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<CategoryDTO> getAllCategories(){

        return categoryService.findAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryById(@PathVariable Long id){

        return categoryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO postCategory(@RequestBody CategoryDTO category){
        return categoryService.save(category);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO putCategory(@RequestBody CategoryDTO category, @PathVariable Long id){
        return categoryService.saveCategory(id, category);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable Long id){
        categoryService.deletById(id);
    }
}
