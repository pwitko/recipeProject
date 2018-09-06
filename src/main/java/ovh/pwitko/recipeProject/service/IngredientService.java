package ovh.pwitko.recipeProject.service;

import org.springframework.stereotype.Service;
import ovh.pwitko.recipeProject.model.Ingredient;


import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService implements IngredientServ {


    private List<Ingredient> ingredientList = new ArrayList<>();


    @Override
    public void addIngredient(String ingredientName) {
        Ingredient ingredient = new Ingredient(ingredientName);
        ingredientList.add(ingredient);
    }

    @Override
    public List showAllIngredients() {
         return ingredientList;
    }

    @Override
    public void removeAllIngredients() {
        ingredientList.clear();
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }


}
