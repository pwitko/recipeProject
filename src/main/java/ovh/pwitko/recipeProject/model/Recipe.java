package ovh.pwitko.recipeProject.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToMany
    @JoinColumn(name = "recipe_id")
    private List<Ingredient> IngredientList;

    public List<Ingredient> getIngredientList() {
        return IngredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        IngredientList = ingredientList;
    }


    public Recipe(List<Ingredient> ingredientList) {
        IngredientList = ingredientList;
    }

    public Recipe() {
    }

}

