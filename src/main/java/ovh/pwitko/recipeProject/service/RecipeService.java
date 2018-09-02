package ovh.pwitko.recipeProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.pwitko.recipeProject.model.Recipe;
import ovh.pwitko.recipeProject.repository.RecipeCrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService implements RecipeServ {

    private List<Recipe> recipeList = new ArrayList<>();

    @Autowired
    private RecipeCrudRepository recipeCrudRepository;

    @Override
    public void addRecipe(Recipe recipe) {
        recipeCrudRepository.save(recipe);
    }

    @Override
    public Optional<Recipe> showRecipe(Integer recipeId) {
        Optional<Recipe> recipe = recipeCrudRepository.findById(recipeId);
        return recipe;
    }

}
