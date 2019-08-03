package springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model.CategoryDTO;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Category;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO category2categoryDTO(Category category);

    Category categoryDTO2category(CategoryDTO categoryDTO);
}
