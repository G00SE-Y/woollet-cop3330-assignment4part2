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
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class ListCatalogController {

	public static Stage ListCatalogStage;
	private Stage stage = new Stage();

	private static ToDoList selected;

	private static ObservableList<ToDoList> catalog;

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

	public static ToDoList getSelected() {
		return selected;
	}

	@FXML
	public void initialize() throws IOException, ParseException {
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		sizeColumn.setCellValueFactory(cellData -> cellData.getValue().sizeProperty());

		catalog = FXCollections.observableArrayList();
		catalog.addAll(ToDoApp.catalog.getCatalog());
		tableView.setItems(catalog);

		tableView.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> updateSelected(newValue)
		);

	}

	private void updateSelected(ToDoList newValue) {
		selected = newValue;
		ToDoApp.activeList = newValue;
	}

	@FXML
	void renameButtonClicked (ActionEvent action) throws IOException {

		// open a new window to prompt the user for a new lists name to overwrite the old list's name
		// update the list's name to the new name
		// update window

		if(selected == null)
			return;

		ToDoApp.selectedList = selected;

		Parent root = FXMLLoader.load(getClass().getResource("RenameListGUI.fxml"));
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();

		FXMLLoader loader = new FXMLLoader();
		RenameListController controller = new RenameListController();

		controller.setDialogStage(this.stage);
		controller.setList(selected);
		loader.setController(controller);



	}

	@FXML
	void newButtonClicked (ActionEvent action) throws IOException {

		// prompt the user for a list name
		// create a new list using a name the user enters
		// update window

		selected = new ToDoList("");
		ToDoApp.activeList = selected;

		Parent root = FXMLLoader.load(getClass().getResource("AddListGUI.fxml"));
		Scene scene = new Scene(root);

		stage.setTitle("New List");
		stage.setScene(scene);
		stage.show();

		FXMLLoader loader = new FXMLLoader();
		AddListController controller = new AddListController();
		controller.setDialogStage(this.stage);
		loader.setController(controller);
	}

	@FXML
	void deleteButtonClicked (ActionEvent action) {

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

		ToDoApp.activeList = selected;
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
