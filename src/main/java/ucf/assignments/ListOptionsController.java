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
	private Stage dialogStage = new Stage();

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

	private static ToDoItem selected;

	private ToDoList toDoList;
	private ObservableList<ToDoItem> list;

	@FXML private TableView<ToDoItem> tableView;
	@FXML private TableColumn<ToDoItem,String> nameColumn;


	@FXML
	private void initialize() {

		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

		this.list = FXCollections.observableArrayList();
		this.list.addAll(ToDoApp.activeList.getList());
		this.listName.setText(ToDoApp.activeList.getName());

		tableView.setItems(this.list);

		tableView.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showItem(newValue)
		);

		showItem(null);


	}

	public void setStage(Stage stage) {
		dialogStage = stage;
		ListOptionsStage = stage;
		ListOptionsStage.setResizable(false);
	}

	public static ToDoItem getSelected() {
		return selected;
	}

	private void showItem(ToDoItem newValue) {
		selected = newValue;

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
	void completeBoxChecked(ActionEvent event) {
		// update the current item's 'complete' value
		if(selected == null)
			return;

		selected.swapComplete();
	}

	@FXML
	void allButtonClicked(ActionEvent event) {
		// show all items in the current list
		list = FXCollections.observableArrayList();
		list.addAll(ToDoApp.activeList.getList());
		tableView.setItems(list);
	}

	@FXML
	void completedButtonClicked(ActionEvent event) {
		// only show all the items in the current list marked as 'complete'
		ToDoList visibleList = new ToDoList(ToDoApp.activeList.getName());
		for(ToDoItem item : ToDoApp.activeList.getList()) {
			if(item.isComplete())
				visibleList.addItem(item);
		}
		list = FXCollections.observableArrayList();
		list.addAll(visibleList.getList());
		tableView.setItems(list);
	}

	@FXML
	void deleteButtonClicked(ActionEvent event) {

		// get the currently viewed item's data and create a new temporary object
		// ask the user to confirm whether or not they want to follow through with the deletion
			// if yes, then call the deletion method for that list
			// if no, return and do nothing

		if(selected == null)
			return;

		try {
			ToDoApp.activeList.getList().remove(selected);

			Parent root = FXMLLoader.load(getClass().getResource("ListOptionsGUI.fxml"));
			Scene scene = new Scene(root);

			ToDoApp.mainScene.setScene(scene);
			ToDoApp.mainScene.show();

			FXMLLoader loader = new FXMLLoader();
			ListOptionsController controller = new ListOptionsController();
			controller.setStage(ToDoApp.mainScene);
			loader.setController(controller);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void editButtonClicked(ActionEvent event) throws IOException {

		// get the currently viewed item's data and create a new temporary object
		// ask the user for updated information
		// call the edit item method for that list
		// return to list page

		if(selected == null)
			return;

		Parent root = FXMLLoader.load(getClass().getResource("EditItemGUI.fxml"));

		Scene scene = new Scene(root);

		dialogStage.setTitle("Edit Item");
		dialogStage.setScene(scene);
		dialogStage.show();

		FXMLLoader loader = new FXMLLoader();
		EditItemController controller = new EditItemController();
		controller.setDialogStage(dialogStage);
		loader.setController(controller);
	}

	@FXML
	void incompleteButtonClicked(ActionEvent event) {
		// only show all the of the items in the current list marked as 'incomplete'

		ToDoList visibleList = new ToDoList(ToDoApp.activeList.getName());
		for(ToDoItem item : ToDoApp.activeList.getList()) {
			if(!item.isComplete())
				visibleList.addItem(item);
		}
		list = FXCollections.observableArrayList();
		list.addAll(visibleList.getList());
		tableView.setItems(list);
	}

	@FXML
	void newButtonClicked(ActionEvent event) throws IOException {

		// prompt the user for new item data
		// use data to create a new item object
		// call add item method to current list

		Parent root = FXMLLoader.load(getClass().getResource("AddItemGUI.fxml"));
		Scene scene = new Scene(root);

		dialogStage.setTitle("New Item");
		dialogStage.setScene(scene);
		dialogStage.show();

		FXMLLoader loader = new FXMLLoader();
		AddItemController controller = new AddItemController();
		controller.setDialogStage(dialogStage);
		loader.setController(controller);
	}

	@FXML
	void returnToListsButtonClicked(ActionEvent event) throws IOException {

		// reopen/bring the catalog window the the foreground
		// close list window

		Parent root = FXMLLoader.load(getClass().getResource("ListCatalogGUI.fxml"));

		Scene scene = new Scene(root);
		ToDoApp.mainScene.setScene(scene);
		ToDoApp.mainScene.show();

		FXMLLoader loader = new FXMLLoader();
		loader.setController(new ListCatalogController(ToDoApp.mainScene));
	}

	@FXML
	void saveListButtonClicked(ActionEvent action) throws IOException {
		Parser.parseToCatalogFile(ToDoApp.catalog);
		Parser.parseToListFile(ToDoApp.activeList);
	}

	public ListOptionsController() {}
}
