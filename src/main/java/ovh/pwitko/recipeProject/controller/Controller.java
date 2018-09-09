package ovh.pwitko.recipeProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.pwitko.recipeProject.form.RecipeForm;
import ovh.pwitko.recipeProject.model.Ingredient;
import ovh.pwitko.recipeProject.form.IngredientForm;
import ovh.pwitko.recipeProject.model.Recipe;
import ovh.pwitko.recipeProject.repository.*;
import ovh.pwitko.recipeProject.service.IngredientService;
import ovh.pwitko.recipeProject.service.RecipeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


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

    @GetMapping("/")
    public String form() {
        return "redirect:author";
    }

    @RequestMapping(value = "/author")
    public String author() {
        return "author";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping(value = {"recipeProject/addIng"}, method = RequestMethod.POST)
    public String addIng(Model model, @ModelAttribute("ingredientForm") IngredientForm ingredientForm) {

        String ingredientName = ingredientForm.getIngredientName();

        if (ingredientName != null && ingredientName.length() > 0) {
            Ingredient newIngredient = new Ingredient(ingredientName);
            ingredientService.addIngredient(newIngredient);
            ingredientCrudRepository.save(newIngredient);
            return "redirect:/recipeProject/addRecipe";
        }
        return "redirect:/recipeProject/addRecipe";
    }

    @RequestMapping(value = {"/recipeProject/addRecipe"}, method = RequestMethod.GET)
    public String showAddRecipePage(Model model) {
        IngredientForm ingredientForm = new IngredientForm();
        RecipeForm recipeForm = new RecipeForm();
        model.addAttribute("recipeForm", recipeForm);
        model.addAttribute("ingredientForm", ingredientForm);
        model.addAttribute("ingredient", ingredientService.showAllIngredients());


        return "addRecipe";
    }

    @RequestMapping(method = RequestMethod.POST, value = "recipeProject/addRecipe")
    public String addRecipe(Model model, @ModelAttribute("recipeForm") RecipeForm recipeForm) {
        IngredientForm ingredientForm = new IngredientForm();
        String recipeName = recipeForm.getRecipeName();
        String recipeDescription = recipeForm.getDescription();
        String peopleQuantity = recipeForm.getPeopleQuantity();
        String preparationTime = recipeForm.getPreparationTime();
        model.addAttribute("ingredientForm", ingredientForm);
        List ingredientList = new ArrayList();
        ingredientList.addAll(ingredientService.showAllIngredients());
        Recipe newRecipe = new Recipe(ingredientList, recipeDescription, recipeName, preparationTime, peopleQuantity);
        recipeCrudRepository.save(newRecipe);
        ingredientService.removeAllIngredients();
        return "redirect:/recipeProject/recipeList";
    }

    @RequestMapping(method = RequestMethod.GET, value = "recipeProject/showRecipe/{recipeId}")
    public String showRecipe(Model model, @PathVariable Integer recipeId) {
        model.addAttribute("recipe", recipeCrudRepository.findById(recipeId).get());
        model.addAttribute("ingredient", recipeCrudRepository.findById(recipeId).get().getIngredientList());
        return "recipeView";
    }

    @RequestMapping(method = RequestMethod.GET, value = "recipeProject/recipeList")
    public String showRecipeList(Model model) {
        model.addAttribute("recipeList", recipeCrudRepository.findAll());
        return "recipeList";
    }

    @RequestMapping(method = RequestMethod.GET, value = "recipeProject/deleteRecipe/{recipeId}")
    public String deleteRecipe(Model model, @PathVariable Integer recipeId) {
        model.addAttribute("recipe", recipeCrudRepository.findById(recipeId));
        Recipe recipe = recipeCrudRepository.findById(recipeId).get();
        recipeCrudRepository.delete(recipe);
        return "redirect:/recipeProject/recipeList";
    }

    @RequestMapping(value = {"/recipeProject/editRecipe/{recipeId}"}, method = RequestMethod.GET)
    public String editRecipe(Model model, @PathVariable Integer recipeId) {
        IngredientForm ingredientForm = new IngredientForm();
        RecipeForm recipeForm = new RecipeForm();
        model.addAttribute("recipeForm", recipeForm);
        model.addAttribute("ingredientForm", ingredientForm);
        model.addAttribute("recipe", recipeCrudRepository.findById(recipeId).get());
        model.addAttribute("ingredient", recipeCrudRepository.findById(recipeId).get().getIngredientList());
        return "editRecipe";
    }

}
