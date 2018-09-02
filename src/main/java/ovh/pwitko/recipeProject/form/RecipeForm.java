package ovh.pwitko.recipeProject.form;

public class RecipeForm {

    private String recipeName;
    private String description;
    private String preparationTime;
    private String peopleQuantity;

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getPeopleQuantity() {
        return peopleQuantity;
    }

    public void setPeopleQuantity(String peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecipeName() {

        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
