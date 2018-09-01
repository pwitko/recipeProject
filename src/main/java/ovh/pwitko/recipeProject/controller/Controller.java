package ovh.pwitko.recipeProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.pwitko.recipeProject.model.Ingredient;
import ovh.pwitko.recipeProject.form.IngredientForm;
import ovh.pwitko.recipeProject.repository.IngredientCrudRepository;
import ovh.pwitko.recipeProject.repository.IngredientRepository;
import ovh.pwitko.recipeProject.service.IngredientService;


@org.springframework.stereotype.Controller
public class Controller {


    @Autowired
    private IngredientService ingredientService;

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

    @RequestMapping(value = { "/addIngredient" }, method = RequestMethod.GET)
    public String showAddIngredientPage(Model model) {
        IngredientForm ingredientForm = new IngredientForm();
        model.addAttribute("ingredientForm", ingredientForm);
        return "addIngredient";
    }

    @RequestMapping(value = { "/addIngredient" }, method = RequestMethod.POST)
    public String addIngredient (Model model, @ModelAttribute("ingredientForm") IngredientForm ingredientForm) {

        String ingredientName = ingredientForm.getIngredientName();

        if (ingredientName != null && ingredientName.length() > 0 ) {
            Ingredient newIngredient = new Ingredient(ingredientName);
            ingredientService.addIngredient(newIngredient);
            return "redirect:/ingredientList";
        }
        return "addIngredient";
    }


}
