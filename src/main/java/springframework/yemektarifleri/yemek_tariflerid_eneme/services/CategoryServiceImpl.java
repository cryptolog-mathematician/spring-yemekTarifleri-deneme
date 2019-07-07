package springframework.yemektarifleri.yemek_tariflerid_eneme.services;

import org.springframework.stereotype.Service;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Category;
import springframework.yemektarifleri.yemek_tariflerid_eneme.repositories.CategoryRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(Long aLong) {
        return categoryRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Category> findByAll() {
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public Category save(Category object) {
        return categoryRepository.save(object);
    }

    @Override
    public void delete(Category object) {
        categoryRepository.delete(object);
    }

    @Override
    public void deletById(Long aLong) {
        categoryRepository.deleteById(aLong);
    }
}
