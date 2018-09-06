package ovh.pwitko.recipeProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ovh.pwitko.recipeProject.model.Ingredient;
import ovh.pwitko.recipeProject.model.Recipe;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeCrudRepository extends CrudRepository<Recipe, Integer> {

    Optional<Recipe> findById(Integer id);
    List<Ingredient> findIngredientListById(Integer id);
}
