package springframework.yemektarifleri.yemek_tariflerid_eneme.models;



import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImege() {
        return imege;
    }

    public void setImege(Byte[] imege) {
        this.imege = imege;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        if (notes != null) {
            this.notes = notes;
            notes.setRecipe(this);
        }
    }

    public Set<Ingradient> getIngradients() {
        return ingradients;
    }

    public void setIngradients(Set<Ingradient> ingradients) {
        this.ingradients = ingradients;
    }

    public Recipe addIngradient(Ingradient ingradient) {
        this.ingradients.add(ingradient);
        ingradient.setRecipe(this);
        return this;
    }
}
