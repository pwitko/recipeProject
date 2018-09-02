package ovh.pwitko.recipeProject.service;

import org.springframework.stereotype.Service;
import ovh.pwitko.recipeProject.model.Recipe;

import java.util.Optional;

@Service
public interface RecipeServ {

    void addRecipe (Recipe recipe);

    Optional<Recipe> showRecipe(Integer recipeId);
}
