/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;


public class ToDoItem {
	private SimpleStringProperty name;
	private SimpleStringProperty description;
	private LocalDate date;
	private boolean complete;

	public String getName() {
		return name.get();
	}

	public SimpleStringProperty nameProperty() {
		return name;
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getDescription() {
		return description.get();
	}

	public SimpleStringProperty descriptionProperty() {
		return description;
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public ToDoItem(String name, String description, LocalDate date) {
		this.name = new SimpleStringProperty(name);
		this.description = new SimpleStringProperty(description) ;
		this.date = date;
		this.complete = false;
	}
}
