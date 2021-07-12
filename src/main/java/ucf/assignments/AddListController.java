/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;


public class AddListController {

	@FXML
	private TextField newListName = new TextField();

	private Stage dialogStage;
	public static Stage AddListStage;

	@FXML
	private void initialize() {
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
		AddListStage = this.dialogStage;
		AddListStage.setResizable(false);
	}

	@FXML
	private void submitButtonClicked() {

		// check if name is valid
		// add new list with input name

		if (isInputValid()) {
			ToDoList newList = new ToDoList(newListName.getText());
			ToDoApp.catalog.addList(newList);

			try {
				ListCatalogController.ListCatalogStage.close();

				Parent root = FXMLLoader.load(getClass().getResource("ListCatalogGUI.fxml"));
				Scene scene = new Scene(root);

				ToDoApp.mainScene.setScene(scene);
				ToDoApp.mainScene.show();

				FXMLLoader loader = new FXMLLoader();
				ListCatalogController controller = new ListCatalogController(ToDoApp.mainScene);
				loader.setController(controller);
			} catch (IOException e) {
				e.printStackTrace();
			}

			AddListStage.close();
		}
	}

	@FXML
	private void cancelButtonClicked() {
		AddListStage.close();
	}

	private boolean isInputValid() {

		// check if name is alphanumeric
		// check if name is 1-20 characters long
		// check if another list with the same name already exists
		// if any of the above are incorrect, create an error dialog and ask the user to fix the input data

		String errorMessage = "";

		if(Pattern.matches("\\W+", newListName.getText())) {
			errorMessage += "A list name can only contain letters!\n";
		}
		for(ToDoList list : ToDoApp.catalog.getCatalog())
			if(list.getName().equalsIgnoreCase(newListName.getText())) {
				errorMessage += "List already exists!\n";
				break;
			}

		if (newListName.getText() == null || newListName.getText().length() == 0 ) {
			errorMessage += "No valid first name!\n";
		}
		if (newListName.getText().length() >20) {
			errorMessage += "Name too long!\n";
		}

		if(newListName.getText().equalsIgnoreCase("catalog"))
			errorMessage += "'Catalog' is a protected word. Sorry!\n";

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}
