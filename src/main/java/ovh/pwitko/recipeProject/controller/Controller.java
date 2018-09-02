package ovh.pwitko.recipeProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.pwitko.recipeProject.form.RecipeForm;
import ovh.pwitko.recipeProject.model.Ingredient;
import ovh.pwitko.recipeProject.form.IngredientForm;
import ovh.pwitko.recipeProject.model.Recipe;
import ovh.pwitko.recipeProject.repository.IngredientCrudRepository;
import ovh.pwitko.recipeProject.repository.IngredientRepository;
import ovh.pwitko.recipeProject.repository.RecipeCrudRepository;
import ovh.pwitko.recipeProject.repository.RecipeRepository;
import ovh.pwitko.recipeProject.service.IngredientService;
import ovh.pwitko.recipeProject.service.RecipeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeCrudRepository recipeCrudRepository;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    protected IngredientRepository ingredientRepository;

    @Autowired
    protected IngredientCrudRepository ingredientCrudRepository;

    @GetMapping("/findById/{id}")
    public String findIngredientById(@PathVariable Integer id) {
        return ingredientRepository.findById(id).toString();
    }

    @GetMapping("/save/{ingredientName}")
    public String saveIngredient(@PathVariable String ingredientName) {
        ingredientCrudRepository.save(new Ingredient(ingredientName));
        return "ingredientList";
    }

    @GetMapping("/")
    public String form() {
        return "index";
    }

    @RequestMapping(value = "/author")
    public String author() {
        return "author";
    }


    @GetMapping("/ingredientList")
    public String ingredientList(Model model) {
        model.addAttribute("ingredient", ingredientService.showAllIngredients());
        return "ingredientList";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addIngredient/{ingredientName}")
    public void addIngredientToList(@PathVariable String ingredientName) {
        ingredientService.addIngredient(ingredientName);
    }

    @RequestMapping(value = {"/addIngredient"}, method = RequestMethod.GET)
    public String showAddIngredientPage(Model model) {
        IngredientForm ingredientForm = new IngredientForm();
        model.addAttribute("ingredientForm", ingredientForm);
        model.addAttribute("ingredient", ingredientService.showAllIngredients());
        return "addIngredient";
    }

    @RequestMapping(value = {"/addIngredient"}, method = RequestMethod.POST)
    public String addIngredient(Model model, @ModelAttribute("ingredientForm") IngredientForm ingredientForm) {

        String ingredientName = ingredientForm.getIngredientName();

        if (ingredientName != null && ingredientName.length() > 0) {
            Ingredient newIngredient = new Ingredient(ingredientName);
            ingredientService.addIngredient(newIngredient);
            ingredientCrudRepository.save(newIngredient);
            return "redirect:/addIngredient";
        }
        return "addIngredient";
    }

    @RequestMapping(value = {"/addIng"}, method = RequestMethod.POST)
    public String addIng(Model model, @ModelAttribute("ingredientForm") IngredientForm ingredientForm) {

        String ingredientName = ingredientForm.getIngredientName();

        if (ingredientName != null && ingredientName.length() > 0) {
            Ingredient newIngredient = new Ingredient(ingredientName);
            ingredientService.addIngredient(newIngredient);
            ingredientCrudRepository.save(newIngredient);
            return "redirect:/addRecipe";
        }
        return "addRecipe";
    }

    @RequestMapping(value = {"/addRecipe"}, method = RequestMethod.GET)
    public String showAddRecipePage(Model model) {
        IngredientForm ingredientForm = new IngredientForm();
        RecipeForm recipeForm = new RecipeForm();
        model.addAttribute("recipeForm", recipeForm);
        model.addAttribute("ingredientForm", ingredientForm);
        model.addAttribute("ingredient", ingredientService.showAllIngredients());
        return "addRecipe";
    }

    @RequestMapping(method = RequestMethod.POST, value = "addRecipe")
    public String addIngredientToRecipe(Model model, @ModelAttribute("recipeForm") RecipeForm recipeForm) {
        IngredientForm ingredientForm = new IngredientForm();
        String recipeName = recipeForm.getRecipeName();
        String recipeDescription = recipeForm.getDescription();
        String peopleQuantity = recipeForm.getPeopleQuantity();
        String preparationTime = recipeForm.getPreparationTime();
        model.addAttribute("ingredientForm", ingredientForm);
        List ingredientList = new ArrayList();
        ingredientList.addAll((Collection) ingredientCrudRepository.findAll());
        Recipe newRecipe = new Recipe(ingredientList, recipeDescription, recipeName, preparationTime, peopleQuantity);
        recipeCrudRepository.save(newRecipe);
        return "redirect:/recipeList";
    }

    @RequestMapping(method = RequestMethod.GET, value = "showRecipe/{recipeId}")
    public String showRecipe(Model model,@PathVariable Integer recipeId) {
        model.addAttribute("recipe", recipeCrudRepository.findById(recipeId).get());
        model.addAttribute("ingredient", ingredientCrudRepository.findAll());
        return "recipeView";
    }

    @RequestMapping(method = RequestMethod.GET, value = "recipeList")
    public String showRecipeList(Model model) {
        model.addAttribute("recipeList", recipeCrudRepository.findAll());
        return "recipeList";
    }

}
