package ovh.pwitko.recipeProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import ovh.pwitko.recipeProject.model.Ingredient;

import java.util.List;

public interface IngredientRepository extends Repository<Ingredient, Integer> {

    Ingredient findById(Integer id);

//    @Query("SELECT * FROM ingredients where recipe_id = id;")
//    List<Ingredient> findByRecipeId(@Param("id") Integer id);

}
