/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ListOptionsController {
	public static Stage ListOptionsStage;

	private Stage stage = new Stage();

	@FXML
	private Label listName;

	@FXML
	private CheckBox completed;

	@FXML
	private Label itemDescription;

	@FXML
	private Label itemDate;

	@FXML
	private Label itemName;

	private ToDoItem selected;

	private ToDoList toDoList;
	private ObservableList<ToDoItem> list;

	@FXML private TableView<ToDoItem> tableView;
	@FXML private TableColumn<ToDoItem,String> nameColumn;


	@FXML
	private void initialize() {

		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

		this.list = FXCollections.observableArrayList();
		this.list.addAll(ListCatalogController.getSelected().getList());

		tableView.setItems(this.list);

		tableView.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showItem(newValue)
		);


		this.listName.setText(ListCatalogController.getSelected().getName());
		showItem(null);

		this.toDoList = new ToDoList("");
	}

	private void tryCheck(ToDoItem selected) {
		System.out.println("here");
		if(this.selected != null)
			this.selected.setComplete();
	}

	public ListOptionsController (Stage stage, ToDoList list) {
		this.stage = stage;
		ListOptionsStage = this.stage;
	}

	private void showItem(ToDoItem newValue) {
		this.selected = newValue;

		if(newValue == null) {
			this.itemName.setText("");
			this.itemDate.setText("");
			this.itemDescription.setText("");
			return;
		}

		this.itemName.setText(newValue.getName());
		this.itemDate.setText(newValue.getDate().toString());
		this.itemDescription.setText(newValue.getDescription());
		this.completed.setSelected(newValue.isComplete());
	}

	@FXML
	void allButtonClicked(ActionEvent event) {
		// show all items in the current list
	}

	@FXML
	void completeBoxChecked(ActionEvent event) {
		// update the current item's 'complete' value
		if(this.selected == null)
			return;

		this.selected.setComplete();

		System.out.println(this.selected.isComplete());
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
		loader.setController(new ConfirmDeleteController());
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


	public ListOptionsController() {}
}
