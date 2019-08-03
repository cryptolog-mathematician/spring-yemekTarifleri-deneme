package springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Category;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Ingradient;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.Notes;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDTO {

    private Long id;

    private String description;
    private String prepTime;
    private String cookTime;

    private String servings;
    private String source;
    private String directions;

    private Set<Ingradient> ingradients;
    private Byte[] imege;
    private Notes notes;

    private Set<Category> categories;
}
