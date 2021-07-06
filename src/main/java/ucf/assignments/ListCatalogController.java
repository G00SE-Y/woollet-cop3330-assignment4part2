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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ListCatalogController implements Initializable {

	public static Stage ListCatalogStage;

	private Stage stage = new Stage();

	public ListCatalogController() {
	}

	public ListCatalogController (Stage stage) {
		this.stage = stage;
		ListCatalogStage = this.stage;
	}

	//for displaying the table
	@FXML private final TableView<Catalog> tableView = new TableView<>();
	@FXML private TableColumn<ToDoList, String> nameColumn;
	@FXML private TableColumn<ToDoList, String> sizeColumn;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		// initialize the table for the page when this stage is loaded

		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));

		ObservableList<ToDoList> lists = FXCollections.observableArrayList();
		lists.add(new ToDoList("Chores"));
		lists.add(new ToDoList("Homework"));

	}

	@FXML
	void renameButtonClicked (ActionEvent action) throws IOException {

		// open a new window to prompt the user for a new lists name to overwrite the old list's name
		// update the list's name to the new name
		// update window

		System.out.println("rename list");

		Parent root = FXMLLoader.load(getClass().getResource("AddListGUI.fxml"));
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();

		FXMLLoader loader = new FXMLLoader();
		loader.setController(new AddListController(stage));
	}

	@FXML
	void newButtonClicked (ActionEvent action) throws IOException {

		// prompt the user for a list name
		// create a new list using a name the user enters
		// update window

		System.out.println("new list");

		Parent root = FXMLLoader.load(getClass().getResource("AddListGUI.fxml"));
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();

		FXMLLoader loader = new FXMLLoader();
		loader.setController(new AddListController(stage));
	}

	@FXML
	void deleteButtonClicked (ActionEvent action) throws IOException {

		// prompt the user to confirm the deletion in a new window
			// if confirmed, delete the list and update the catalog
			// otherwise close window and do nothing

		System.out.println("delete list");

		Parent root = FXMLLoader.load(getClass().getResource("ConfirmDeleteGUI.fxml"));
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();

		FXMLLoader loader = new FXMLLoader();
		loader.setController(new ConfirmDeleteController(stage));

	}

	@FXML
	void saveListButtonClicked (ActionEvent action) {

		// create a linked list of lists that the use had selected when the button was pressed
		// call the save function within the data storage class to save the selected lists into long term memory

		System.out.println("saved list");
	}

	@FXML
	void saveAllListsButtonClicked (ActionEvent action) {

		// call the save function within the data storage class to save all lists in active memory into long term memory

		System.out.println("saved all lists");
	}

	@FXML
	void onTableItemDoubleClicked(ActionEvent action) {

		// create the list options window for the list that was double clicked on

	}
}
