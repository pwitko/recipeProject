package ovh.pwitko.recipeProject.model;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Column(name = "ingredient_names")
    private String ingredientName;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;


    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ingredient() {
    }

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientName='" + ingredientName + '\'' +
                ", id=" + id +
                '}';
    }
}

