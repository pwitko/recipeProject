package ovh.pwitko.recipeProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ovh.pwitko.recipeProject.model.Ingredient;

import java.util.Optional;

@Repository
public interface IngredientCrudRepository extends CrudRepository<Ingredient, Integer> {

 Optional<Ingredient> findById(Integer id);

}
