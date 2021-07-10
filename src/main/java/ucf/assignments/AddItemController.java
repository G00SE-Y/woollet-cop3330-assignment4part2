/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddItemController {
	private Stage stage;

	@FXML
	private TextField name;
	@FXML
	private TextField description;
	@FXML
	private DatePicker date;


	public AddItemController(Stage stage) {
		this.stage = stage;
	}

	public AddItemController () {}

	@FXML
	void submitButtonClicked(ActionEvent action) {

		// create a new object from user inputted data
		// add to/replace the object depending on the context

		System.out.println("new item created:");
		System.out.println(this.name.getCharacters() + ", " + this.date.getValue() + ", " +this.description.getCharacters());

	}

	@FXML
	void cancelButtonClicked (ActionEvent action) {
		this.stage.close();
	}
}
