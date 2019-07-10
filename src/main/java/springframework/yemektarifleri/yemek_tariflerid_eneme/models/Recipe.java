package springframework.yemektarifleri.yemek_tariflerid_eneme.models;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 4, max = 100)
    private String description;

    @Min(5)
    @Max(120)
    private String prepTime;

    @Min(5)
    @Max(360)
    private String cookTime;

    @Min(1)
    @Max(40)
    private String servings;
    private String source;

    @NotBlank
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingradient> ingradients;

    @Lob
    private Byte[] imege;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

     @ManyToMany
     @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
     private Set<Category> categories;

    public void setNotes(Notes notes) {
        if (notes != null) {
            this.notes = notes;
            notes.setRecipe(this);
        }
    }

    public Recipe addIngradient(Ingradient ingradient) {
        this.ingradients.add(ingradient);
        ingradient.setRecipe(this);
        return this;
    }
}
