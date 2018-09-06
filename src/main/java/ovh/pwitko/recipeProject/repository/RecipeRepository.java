package ovh.pwitko.recipeProject.repository;


import org.springframework.data.repository.Repository;
import ovh.pwitko.recipeProject.model.Ingredient;
import ovh.pwitko.recipeProject.model.Recipe;

import java.util.List;

public interface RecipeRepository extends Repository<Recipe, Integer> {

    Recipe findById(Integer id);

}
