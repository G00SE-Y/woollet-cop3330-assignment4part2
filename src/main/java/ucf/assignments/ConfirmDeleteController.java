/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ConfirmDeleteController {

	private Stage stage = new Stage();

	public static Stage ConfirmDeleteStage;

	public ConfirmDeleteController(Stage stage) {
		this.stage = stage;
		ConfirmDeleteStage = this.stage;
	}

	public ConfirmDeleteController () {}

	@FXML
	void cancelButtonClicked(ActionEvent action) {
		System.out.println("action canceled");
		ConfirmDeleteStage.close();
	}

	@FXML
	void confirmButtonClicked (ActionEvent action) {
		System.out.println("action confirmed");
		ConfirmDeleteStage.close();
	}
}
