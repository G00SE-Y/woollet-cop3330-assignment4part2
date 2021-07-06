/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ListOptionsController {
	public static Stage ListOptionsStage;

	private Stage stage = new Stage();

	@FXML
	private TextArea listName;

	@FXML
	private TableView<ToDoItem> table;

	@FXML
	private CheckBox completed;

	@FXML
	private TextArea itemDescription;

	@FXML
	private TextArea itemDate;

	@FXML
	private TextArea itemName;

	@FXML
	void allButtonClicked(ActionEvent event) {
		// show all items in the current list
	}

	@FXML
	void completeBoxChecked(ActionEvent event) {
		// update the current item's complete value
	}

	@FXML
	void completedButtonClicked(ActionEvent event) {
		// only show all the items in the current list marked as 'complete'
	}

	@FXML
	void deleteButtonClicked(ActionEvent event) throws IOException {

		// get the currently viewed item's data and create a new temporary object
		// ask the user to confirm whether or not they want to follow through with the deletion
			// if yes, then call the deletion method for that list
			// if no, return and do nothing

		Parent root = FXMLLoader.load(getClass().getResource("ConfirmDeleteGUI.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		FXMLLoader loader = new FXMLLoader();
		loader.setController(new ConfirmDeleteController(stage));
	}

	@FXML
	void editButtonClicked(ActionEvent event) throws IOException {

		// get the currently viewed item's data and create a new temporary object
		// ask the user for updated information
		// call the edit item method for that list
		// return to list page

		Parent root = FXMLLoader.load(getClass().getResource("AddItemGUI.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		FXMLLoader loader = new FXMLLoader();
		loader.setController(new AddItemController(stage));
	}

	@FXML
	void incompleteButtonClicked(ActionEvent event) {
		// only show all the of the items in the current list marked as 'incomplete'
	}

	@FXML
	void newButtonClicked(ActionEvent event) throws IOException {

		// prompt the user for new item data
		// use data to create a new item object
		// call add item method to current list

		Parent root = FXMLLoader.load(getClass().getResource("AddItemGUI.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		FXMLLoader loader = new FXMLLoader();
		loader.setController(new AddItemController(stage));
	}

	@FXML
	void returnToListsButtonClicked(ActionEvent event) throws IOException {

		// reopen/bring the catalog window the the foreground
		// close list window

		Parent root = FXMLLoader.load(getClass().getResource("ListCatalogGUI.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		ListOptionsStage.close();

		FXMLLoader loader = new FXMLLoader();
		loader.setController(new ListCatalogController(stage));
	}


	public ListOptionsController() {
	}

	public ListOptionsController (Stage stage) {
		this.stage = stage;
		ListOptionsStage = this.stage;
	}
}
