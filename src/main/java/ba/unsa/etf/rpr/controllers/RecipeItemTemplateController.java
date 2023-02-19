package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.IngredientManager;
import ba.unsa.etf.rpr.business.InstructionManager;
import ba.unsa.etf.rpr.business.RecipeManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Recipe;
import ba.unsa.etf.rpr.exception.RecipeException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class RecipeItemTemplateController {
    private IngredientManager ingredientManager = new IngredientManager();
    private InstructionManager instructionManager = new InstructionManager();
    private RecipeManager recipeManager = new RecipeManager();
    private UserManager userManager = new UserManager();
    private HomeController homeController;
    private Recipe recipe;
    private boolean editable;

    public Button btnEdit;
    public Button btnDelete;
    public Label lblUsername;
    public Label lblTitle;
    public Label lblTime;
    public Label lblServings;


    public RecipeItemTemplateController(HomeController homeController, Recipe recipe, boolean editable) {
        this.homeController = homeController;
        this.recipe = recipe;
        this.editable = editable;
    }

    @FXML
    public void initialize() {
        if (editable) {
            btnDelete.setVisible(true);
            btnEdit.setVisible(true);
        }
        lblTitle.setText(recipe.getTitle());
        lblUsername.setText(recipe.getOwner().getUsername());
        lblServings.setText("Serves: " + recipe.getServings());
        int time = recipe.getCookTime() + recipe.getPreparationTime();
        int hours = time / 60;
        int minutes = time % 60;
        String timeText = "";
        if (hours > 0) {
            timeText += hours + "h ";
        }
        if (minutes > 0) {
            timeText += minutes + "min";
        }
        lblTime.setText(timeText);
    }

    public void openRecipe(MouseEvent mouseEvent) {
        // TODO
        // homeController.openRecipe(recipe);
    }

    public void actionEdit(ActionEvent actionEvent) {
        homeController.openRecipeForm(recipe);
        homeController.openMyRecipes(null);
    }

    public void actionDelete(ActionEvent actionEvent) {
        try {
            ingredientManager.removeIngredientsByRecipe(recipe);
            instructionManager.removeInstructionsByRecipe(recipe);
            recipeManager.delete(recipe);
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        homeController.openMyRecipes(null);
    }
}
