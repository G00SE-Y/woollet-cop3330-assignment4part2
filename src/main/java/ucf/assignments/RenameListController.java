/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;


public class RenameListController {

	@FXML
	private TextField newListName;

	private Stage dialogStage;
	public static Stage RenameListStage;

	private ToDoList list = new ToDoList("temp");

	@FXML
	private void initialize() {
		newListName.setText(ToDoApp.activeList.getName());
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
		RenameListStage = this.dialogStage;
		RenameListStage.setResizable(false);
	}

	public void setList(ToDoList list) {
		this.list = list;
		System.out.println(this.list.getName());
	}

	@FXML
	private void submitButtonClicked() {

		// check if input is valid
		// edit old list name
		// update files to reflect changes

		if (isInputValid()) {
			String oldName = ToDoApp.activeList.getName();

			ToDoApp.activeList.setName(newListName.getText());
			ListCatalogController.getSelected().setName(newListName.getText());

			try {
				Parser.parseToCatalogFile(ToDoApp.catalog);

				ToDoList temp = new ToDoList(oldName);
				temp.addAllItems(Parser.loadList(oldName));

				temp.setName(newListName.getText());
				Parser.parseToListFile(temp);

				new File(FileHandler.getDirectory() + "/List_Data/"+ oldName +".json").delete();
			} catch (IOException e) {
				e.printStackTrace();
			}

			RenameListStage.close();
		}
	}

	@FXML
	private void cancelButtonClicked() {
		RenameListStage.close();
	}

	private boolean isInputValid() {

		// check if name is alphanumeric
		// check if name is 1-20 characters long
		// check if another list with the same name already exists
		// if any of the above are incorrect, create an error dialog and ask the user to fix the input data

		String errorMessage = "";

		for(ToDoList list : ToDoApp.catalog.getCatalog())
			if(list.getName().equalsIgnoreCase(newListName.getText())) {
				errorMessage += "List already exists!\n";
				break;
			}

		if(Pattern.matches("\\W+", newListName.getText())) {
			errorMessage += "A list name can only contain letters!\n";
		}


		if (newListName.getText() == null || newListName.getText().length() == 0 ) {
			errorMessage += "No valid first name!\n";
		}
		if (newListName.getText().length() >20) {
			errorMessage += "Name too long!\n";
		}

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
