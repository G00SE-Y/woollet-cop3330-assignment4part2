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



public class AddListController {

	@FXML
	private TextField newListName = new TextField();

	private Stage dialogStage;
	public static Stage AddListStage;

	private ToDoList list = new ToDoList("temp");
	private boolean submit = false;


	@FXML
	private void initialize() {
	}


	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
		AddListStage = this.dialogStage;
		AddListStage.setResizable(false);
	}


	public void setList(ToDoList list) {
		this.list = list;
		System.out.println(this.list.getName());
		newListName.setText(list.getName());

	}


	public boolean isSubmitClicked() {
		return submit;
	}

	@FXML
	private void submitButtonClicked() {
		System.out.println("action confirmed");
		if (isInputValid()) {
			list.setName(newListName.getText());

			submit = true;
			AddListStage.close();
		}
	}

	@FXML
	private void cancelButtonClicked() {
		System.out.println("action cancelled");
		AddListStage.close();
	}

	private boolean isInputValid() {
		String errorMessage = "";

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
