package ovh.pwitko.recipeProject.service;

import org.springframework.stereotype.Service;
import ovh.pwitko.recipeProject.model.Recipe;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService implements RecipeServ {

    private List<Recipe> recipeList = new ArrayList<>();

    @Override
    public void addRecipe(Recipe recipe) {
        recipeList.add(recipe);
    }

    @Override
    public Recipe showRecipe(Integer recipeId) {
        Recipe result = recipeList.get(recipeId);
        return result;
    }
}
