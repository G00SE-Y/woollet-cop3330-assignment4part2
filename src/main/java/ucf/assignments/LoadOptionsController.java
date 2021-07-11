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
import javafx.stage.Stage;

import java.io.IOException;

public class LoadOptionsController {

	public static Stage LoadOptionsStage;
	private Stage stage;

	public LoadOptionsController(Stage stage) {
		this.stage = stage;
		LoadOptionsStage = stage;
	}

	public LoadOptionsController() {
		this.stage = new Stage();
	}

	@FXML
	void SelectListsButtonClicked(ActionEvent event) throws IOException {

		// open the select lists window

		System.out.println("selection window");

		Parent root = FXMLLoader.load(getClass().getResource("LoadListsGUI.fxml"));

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();

		LoadOptionsStage.close();

		FXMLLoader loader = new FXMLLoader();
		loader.setController(new LoadListsController(stage));
	}

	@FXML
	void loadAllListsButtonClicked(ActionEvent event) throws IOException {

		//load all lists and open the list options window

		System.out.println("loading all\ncatalog window");

		Parent root = FXMLLoader.load(getClass().getResource("ListCatalogGUI.fxml"));

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();

		LoadOptionsStage.close();

		FXMLLoader loader = new FXMLLoader();
		loader.setController(new ListCatalogController(stage));
	}

	@FXML
	void memeButtonClicked(ActionEvent event) {
		System.out.println("get memed on");
	}
}
