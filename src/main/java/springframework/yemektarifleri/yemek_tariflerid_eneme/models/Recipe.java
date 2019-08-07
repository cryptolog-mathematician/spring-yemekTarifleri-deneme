package springframework.yemektarifleri.yemek_tariflerid_eneme.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Size(min = 4, max = 120)
    private String prepTime;

    @Size(min = 5, max = 360)
    private String cookTime;

    @Size(min = 1, max = 40)
    private String servings;
    private String source;

    //@NotBlank
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingradient> ingradients;

    @Lob   //Large Object
    private byte[] imege;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @JsonIgnore
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
