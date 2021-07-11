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
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ListCatalogController {

	public static Stage ListCatalogStage;
	private Stage stage = new Stage();

	private ToDoList selected;

	private ObservableList<ToDoList> catalog;

	public ListCatalogController() {
	}

	public ListCatalogController (Stage stage) {
		this.stage = stage;
		ListCatalogStage = this.stage;
		ListCatalogStage.setResizable(false);
	}

	//for displaying the table
	@FXML private TableView<ToDoList> tableView;
	@FXML private TableColumn<ToDoList,String> nameColumn;
	@FXML private TableColumn<ToDoList,String> sizeColumn;

	@FXML
	private void initialize() {
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));

		catalog = FXCollections.observableArrayList();
		catalog.add(new ToDoList("Chores"));
		catalog.add(new ToDoList("Homework"));
		catalog.add(new ToDoList("Work"));
		catalog.add(new ToDoList("Classes"));
		catalog.add(new ToDoList("A"));
		catalog.add(new ToDoList("B"));
		catalog.add(new ToDoList("C"));
		catalog.add(new ToDoList("D"));
		catalog.add(new ToDoList("E"));
		catalog.add(new ToDoList("F"));
		catalog.add(new ToDoList("G"));

		tableView.setItems(catalog);

		tableView.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> this.selected = newValue
		);

	}

	@FXML
	void renameButtonClicked (ActionEvent action) throws IOException {

		// open a new window to prompt the user for a new lists name to overwrite the old list's name
		// update the list's name to the new name
		// update window

		if(selected == null)
			return;

		System.out.println("rename list");

		Parent root = FXMLLoader.load(getClass().getResource("AddListGUI.fxml"));
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();

		FXMLLoader loader = new FXMLLoader();
		AddListController controller = new AddListController();

		controller.setDialogStage(this.stage);
		controller.setList(this.selected);
		loader.setController(controller);



	}

	@FXML
	void newButtonClicked (ActionEvent action) throws IOException {

		// prompt the user for a list name
		// create a new list using a name the user enters
		// update window

		System.out.println("new list");

		Parent root = FXMLLoader.load(getClass().getResource("AddListGUI.fxml"));
		Scene scene = new Scene(root);

		stage.setTitle("New List");
		stage.setScene(scene);
		stage.show();

		FXMLLoader loader = new FXMLLoader();
		AddListController controller = new AddListController();
		controller.setDialogStage(this.stage);

		ToDoList newList = new ToDoList("");
		controller.setList(newList);
		loader.setController(controller);
	}

	@FXML
	void deleteButtonClicked (ActionEvent action) throws IOException {

		// prompt the user to confirm the deletion in a new window
			// if confirmed, delete the list and update the catalog
			// otherwise close window and do nothing

		if(this.selected == null)
			return;

		int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
		tableView.getItems().remove(selectedIndex);

	}

	@FXML
	void saveListButtonClicked (ActionEvent action) {

		// create a linked list of lists that the user had selected when the button was pressed
		// call the save function within the data storage class to save the selected lists into long term memory

		DataStorage.saveToMemory(this.selected);

		System.out.println("saved list");
	}

	@FXML
	void saveAllListsButtonClicked (ActionEvent action) {

		// call the save function within the data storage class to save all lists in active memory into long term memory

		for(ToDoList list : this.catalog) {
			DataStorage.saveToMemory(list);
		}

		System.out.println("saved all lists");
	}

	@FXML
	void onTableItemDoubleClicked(ActionEvent action) {

		// create the list options window for the list that was double clicked on

	}
}
