/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddListController {

	private Stage stage = new Stage();

	public static Stage AddListStage;

	@FXML
	private TextField newListName;

	public AddListController(Stage stage) {
		this.stage = stage;
		AddListStage = this.stage;
	}

	public AddListController () {}

	@FXML
	void submitButtonClicked(ActionEvent action) {

		// create a new list with the user's inputted name

		System.out.println("list - '"+ newListName.getText() +"' created");
		AddListStage.close();
	}
}
