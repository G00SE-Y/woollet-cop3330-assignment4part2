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

import java.awt.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class ListCatalogController {

	public static Stage ListCatalogStage;
	private Stage stage = new Stage();

	private static ToDoList selected;

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
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		sizeColumn.setCellValueFactory(cellData -> cellData.getValue().sizeProperty());

		catalog = FXCollections.observableArrayList();
		catalog.add(new ToDoList("Chores"));
		catalog.get(0).addItem(new ToDoItem("monday","take out trash", Parser.parseDate("1999-12-30")));
		catalog.get(0).addItem(new ToDoItem("friday","take out trash", Parser.parseDate("2000-01-04")));
		catalog.add(new ToDoList("A"));
		catalog.add(new ToDoList("B"));


		tableView.setItems(catalog);

		tableView.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> selected = newValue
		);

	}

	public static ToDoList getSelected() {
		return selected;
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

		if(selected == null)
			return;

		int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
		tableView.getItems().remove(selectedIndex);

		selected = null;

	}

	@FXML
	void onOpenButtonClicked(ActionEvent action) throws IOException {

		// create the list options window for the list that was clicked on

		if(this.selected == null)
			return;

		System.out.println("List '" +this.selected.getName() + "' selected:");

		Parent root = FXMLLoader.load(getClass().getResource("ListOptionsGUI.fxml"));
		Scene scene = new Scene(root);

		stage.setTitle("New List");
		stage.setScene(scene);
		stage.show();

		FXMLLoader loader = new FXMLLoader();
		ListOptionsController controller = new ListOptionsController(this.stage, this.selected);
		loader.setController(controller);

		ListCatalogStage.close();

	}

	@FXML
	void memeButtonClicked (ActionEvent action) throws URISyntaxException, IOException {
		System.out.println("meme activated");
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
	}
}
