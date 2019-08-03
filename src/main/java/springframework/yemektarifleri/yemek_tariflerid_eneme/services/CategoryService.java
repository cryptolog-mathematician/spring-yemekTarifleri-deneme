package springframework.yemektarifleri.yemek_tariflerid_eneme.services;

import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model.CategoryDTO;

public interface CategoryService extends CrudService<CategoryDTO, Long> {

    CategoryDTO saveCategory(Long id, CategoryDTO categoryDTO);
}
