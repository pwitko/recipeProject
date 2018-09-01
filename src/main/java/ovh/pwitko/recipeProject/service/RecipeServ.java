package ovh.pwitko.recipeProject.service;

import org.springframework.stereotype.Service;
import ovh.pwitko.recipeProject.model.Recipe;

@Service
public interface RecipeServ {

    void addRecipe (Recipe recipe);

    Recipe showRecipe(Integer recipeId);
}
