
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ToDoApp extends Application {

	public static Stage mainScene;

	public static ToDoList activeList;

	public static Catalog catalog;

	public static void main(String[] args) throws IOException {
		catalog = new Catalog();
		catalog.addAllLists(Parser.loadCatalog());
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ListCatalogGUI.fxml"));
			mainScene = primaryStage;

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("ToDo");
			primaryStage.setResizable(false);
			primaryStage.show();

			FXMLLoader loader = new FXMLLoader();
			ListCatalogController controller = new ListCatalogController(primaryStage);
			loader.setController(controller);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}