/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;


public class ConfirmDeleteController {

	private Stage stage;

	private boolean submit = false;

	public boolean isSubmit() {
		return submit;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public ConfirmDeleteController () {}

	public ConfirmDeleteController (Stage stage) {
		this.stage = stage;
	}

	@FXML
	void cancelButtonClicked(ActionEvent action) {
		stage.close();
	}

	@FXML
	void confirmButtonClicked (ActionEvent action) {
		System.out.println("action confirmed");

		this.submit = true;

		this.stage.close();
	}

//	public boolean getConfirmation() throws IOException {
//
//
//
//		confirmButton.setOnAction(e -> {
//			this.submit = true;
//			System.out.println(true);
//			stage.close();
//		});
//
//		cancelButton.setOnAction(e -> {
//			this.submit = false;
//			System.out.println(false);
//			stage.close();
//		});
//
//		return this.submit;
//	}
}
