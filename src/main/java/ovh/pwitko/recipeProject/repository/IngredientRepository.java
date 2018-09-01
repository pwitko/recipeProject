package ovh.pwitko.recipeProject.repository;

import org.springframework.data.repository.Repository;
import ovh.pwitko.recipeProject.model.Ingredient;

public interface IngredientRepository extends Repository<Ingredient, Integer> {

    Ingredient findById(Integer id);

}
