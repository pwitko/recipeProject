package ovh.pwitko.recipeProject.service;

import org.springframework.stereotype.Service;
import ovh.pwitko.recipeProject.model.Ingredient;

import java.util.List;

@Service
public interface IngredientServ {

    void addIngredient(String ingredientName);

    void addIngredient(Ingredient ingredient);

    List<Ingredient> showAllIngredients();

    void removeAllIngredients();

}
