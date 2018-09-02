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

    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<Ingredient> IngredientList;

    private String description;
    private String recipeName;
    private String preparationTime;
    private String peopleQuantity;

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getPeopleQuantity() {
        return peopleQuantity;
    }

    public void setPeopleQuantity(String peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }

    public Recipe(List<Ingredient> ingredientList, String description, String recipeName) {
        IngredientList = ingredientList;
        this.description = description;
        this.recipeName = recipeName;
    }

    public Recipe(List<Ingredient> ingredientList, String description, String recipeName, String preparationTime, String peopleQuantity) {
        IngredientList = ingredientList;
        this.description = description;
        this.recipeName = recipeName;
        this.preparationTime = preparationTime;
        this.peopleQuantity = peopleQuantity;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public Recipe(List<Ingredient> ingredientList, String description) {
        IngredientList = ingredientList;
        this.description = description;
    }

}

