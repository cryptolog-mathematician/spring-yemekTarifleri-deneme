package springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Recipe;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;
    private String description;
    private Set<Recipe> recipes;
}
