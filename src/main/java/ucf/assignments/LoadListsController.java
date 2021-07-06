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
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadListsController {

	public static Stage LoadListsStage;

	private Stage stage = new Stage();

	public LoadListsController(Stage stage) {
		this.stage = stage;
		LoadListsStage = stage;
	}

	public LoadListsController(){}

	@FXML
	private TableView<?> tableView;

	@FXML
	void LoadListsButtonClicked(ActionEvent event) throws IOException {

		// create a list of the names of user selected list names
		// pass the list to the data storage function to load those lists from long term memory
		// initialize and open the lists in a new window

		System.out.println("load selected\ncatalog window");

		Parent root = FXMLLoader.load(getClass().getResource("ListCatalogGUI.fxml"));

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();

		LoadListsStage.close();

		FXMLLoader loader = new FXMLLoader();
		loader.setController(new ListCatalogController(stage));
	}
}
