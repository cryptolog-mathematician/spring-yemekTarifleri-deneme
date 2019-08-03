package springframework.yemektarifleri.yemek_tariflerid_eneme.services;

import org.springframework.stereotype.Service;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.mapper.CategoryMapper;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model.CategoryDTO;
import springframework.yemektarifleri.yemek_tariflerid_eneme.exceptions.NotFoundException;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Category;
import springframework.yemektarifleri.yemek_tariflerid_eneme.repositories.CategoryRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDTO findById(Long aLong) {

        Optional<Category> category = categoryRepository.findById(aLong);
        if (!category.isPresent()){
            throw new NotFoundException("Category Not Found for id " + aLong.toString());
        }
        CategoryDTO categoryDTO = categoryMapper.category2categoryDTO(category.get());

        return categoryDTO;
    }

    @Override
    public Set<CategoryDTO> findAll() {
     /*   Set<CategoryDTO> categoryDTOSet = categoryRepository.findAll()
                .stream()
                .map(category -> categoryMapper.category2categoryDTO(category))
                .collect(Collectors.toSet());
*/
        Set<Category> categorySet = new HashSet<>();
        categoryRepository.findAll().forEach(categorySet::add);

        Set<CategoryDTO> categoryDTOSet = new HashSet<>();

        for (Category category:categorySet) {
            CategoryDTO categoryDTO = categoryMapper.category2categoryDTO(category);
            categoryDTOSet.add(categoryDTO);
        }

        return categoryDTOSet;
    }

    @Override
    public CategoryDTO save(CategoryDTO object) {
        Category category = categoryRepository.save(categoryMapper.categoryDTO2category(object));
        CategoryDTO categoryDTO = categoryMapper.category2categoryDTO(category);
        return categoryDTO;
    }

    @Override
    public CategoryDTO saveCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(categoryMapper.categoryDTO2category(categoryDTO));
        category.setId(id);
        CategoryDTO categoryDTO1 = categoryMapper.category2categoryDTO(category);
        return categoryDTO1;
    }

    @Override
    public void delete(CategoryDTO object) {
        categoryRepository.deleteById(object.getId());
    }

    @Override
    public void deletById(Long aLong) {
        categoryRepository.deleteById(aLong);
    }
}
